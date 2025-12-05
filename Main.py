import os

def limpiar_pantalla():
    """Limpia la consola para mejorar la experiencia de usuario"""
    os.system('cls' if os.name == 'nt' else 'clear')


def mostrar_menu():
    print("===  Menú Principal - Sistema de Control de Personal ===")
    print("1. Ver lista de empleados")
    print("2. Registrar entrada/salida")
    print("3. Generar reporte de horas trabajadas")
    print("4. Salir")
    print("==========================================================")

def main():
    while True:
        limpiar_pantalla()
        mostrar_menu()
        opcion = input("Seleccione una opción (1-4): ")

        if opcion == "1":
            limpiar_pantalla()
            print("=== Lista de empleados ===\n")
            print("Mostrando lista de empleados..\n")
            input("Presione Enter para continuar...")

        elif opcion == "2":
            limpiar_pantalla()
            print("=== Registrar entrada/salida ===\n")
            print("Registrando entrada y salida..\n")
            input("Presione Enter para continuar...")

        elif opcion == "3":
            limpiar_pantalla()
            print("=== Generar reporte mensual ===\n")
            print("Generando reporte mensual...\n")
            input("Presione Enter para continuar...")

        elif opcion == "4":
            print("\n ¡Gracias por usar el sistema! Hasta pronto.\n")
            break

        else:
            print("\n Opción no válida. Intente nuevamente.")
            input("Presione Enter para continuar...")


if __name__ == "__main__":
    main()