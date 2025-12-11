# backup_mongodb.py
from pymongo import MongoClient
import os
import json
import datetime

MONGO_URI = "mongodb+srv://janmuse:1234@cluster0.ewd6qcz.mongodb.net/control_personal?retryWrites=true&w=majority"

def realizar_respaldo():
    """Realiza un respaldo automático de todas las colecciones"""
    client = MongoClient(MONGO_URI)
    db = client["control_personal"]

    directorio_backup = "respaldos"
    if not os.path.exists(directorio_backup):
        os.makedirs(directorio_backup)

    fecha_actual = datetime.datetime.now().strftime("%Y-%m-%d_%H%M%S")

    respaldo_completo = {}
    for coleccion in ["empleados", "registros", "usuarios"]:
        datos = list(db[coleccion].find({}))
        respaldo_completo[coleccion] = datos

    nombre_archivo = os.path.join(directorio_backup, f"backup_{fecha_actual}.json")
    with open(nombre_archivo, "w", encoding="utf-8") as file:
        json.dump(respaldo_completo, file, indent=4, default=str)

    limpiar_antiguos_respaldo(directorio_backup)
    print(" Respaldo realizado exitosamente")
    print("Guardado en:", os.path.abspath(directorio_backup))



def limpiar_antiguos_respaldo(directorio):
    """Mantiene solo los 3 respaldos más recientes"""
    archivos = [os.path.join(directorio, f) for f in os.listdir(directorio) if f.endswith(".json")]
    archivos.sort(key=os.path.getmtime)
    while len(archivos) > 3:
        os.remove(archivos.pop(0))


def restaurar_respaldo(ruta_json):
    """Restaura una base de datos desde un archivo JSON"""
    try:
        client = MongoClient(MONGO_URI)
        db = client["control_personal"]
        with open(ruta_json, "r", encoding="utf-8") as file:
            datos = json.load(file)
            # Restaurar todas las colecciones
            for coleccion in ["empleados", "registros", "usuarios"]:
                if coleccion in datos:
                    db[coleccion].delete_many({})
                    documentos = []
                    for doc in datos[coleccion]:
                        if "_id" in doc:
                            del doc["_id"]
                        documentos.append(doc)
                    if documentos:
                        db[coleccion].insert_many(documentos)
        return True
    except Exception as e:
        print(f" Error al restaurar: {e}")
        return False
