Sprint Planning - Sistema de Control de Personal 
Sprint Goal Agregar el sistema de gestión de asistencia con registro de entrada/salida, generación de reportes
completos y sistema de respaldos

Historias de usuario seleccionadas: 
HU-07: Registrar Entrada y Salida Prioridad: Alta Story Points: 8 Como supervisor o administrador quiero registrar entrada y salida de empleados Para llevar control de asistencia y calcular horas trabajadas

Criterios de Aceptación:
Permite seleccionar empleado de la lista 
Permite seleccionar fecha con calendario visual 
Permite ingresar hora de entrada y salida en formato HH:MM 
Calcula automáticamente horas normales (máx 8) y extras 
Permite seleccionar tipo de día (Normal, Festivo, Descanso) 
Calcula pago según tipo de día y tarifas 
Guarda registro en MongoDB

HU-08: Generar Reporte de Horas Trabajadas Prioridad: Alta Story Points: 8 Como empleado, supervisor o administrador quiero generar reportes de horas trabajadas por período Para revisar tiempo laborado y pagos

Criterios de Aceptación: 
Permite seleccionar empleados individuales o todos 
Permite seleccionar rango: Día, Semana o Mes 
Permite ingresar fecha o período para filtrar 
Calcula totales: horas normales, extras y pago 
Muestra resultados en tabla organizada Permite reportes de uno o múltiples empleados

HU-09: Exportar Reporte Detallado a PDF Prioridad: Media Story Points: 5 Como administrador o supervisor quiero exportar reportes detallados a PDF Para archivar documentos de nómina

Criterios de Aceptación: 
Genera PDF con título "Reporte Detallado de Horas Trabajadas"
Incluye tabla resumen con totales por empleado
Incluye detalles de cada registro individual por empleado
Guarda como "reporte_personal_detallado.pdf" 
Muestra mensaje de confirmación

HU-10: Realizar Respaldo de Base de Datos Prioridad: Media Story Points: 5 Como administrador quiero realizar respaldos automáticos para proteger la información del sistema

Criterios de Aceptación: 
Crea respaldos en JSON de las colecciones
Guarda en carpeta "respaldos" con fecha y hora 
Mantiene solo los 3 respaldos más recientes
Elimina automáticamente respaldos antiguos
Muestra mensaje de confirmación

HU-11: Restaurar Respaldo Prioridad: Baja Story Points: 3 Como administrador Quiero restaurar desde un archivo de respaldo Para recuperar información en caso de errores

Criterios de Aceptación: 
Permite seleccionar archivo JSON de respaldos
Limpia la colección antes de restaurar 
Inserta datos del respaldo en MongoDB 
Actualiza la interfaz automáticamente
Muestra mensaje de éxito o error

Estimaciones 
Luis - HU-07: Registro de Entrada/Salida (3h)
gui_registro.py: Crear ventana completa con selector de empleados y calendario
Implementar cálculos de horas y pago según tipo de día
Integrar con gui_main.py

Jorge - HU-10 + HU-11: Sistema de Respaldos (3h)
backup_mongodb.py: Implementar realizar_respaldo() y restaurar_respaldo()
gui_main.py: Integrar botones y funcionalidad de respaldos

Baqueiro - HU-09: Exportar PDF (3h)
gui_reporte.py: Implementar función exportar_a_pdf() con ReportLab

Luis - HU-08: Generar Reporte horas trabajadas (3h)
gui_reporte.py: Crear ventana con filtros (empleados, rango, fecha)
Implementar consultas MongoDB y cálculo de totales

Jorge - Testing HU-07, HU-10, HU-11 (2h)
Probar registro de asistencia y respaldos
Validar cálculos y funcionalidades básicas
Corregir bugs encontrados

Baqueiro - Testing HU-08, HU-09 (2h)
Probar reportes y exportación de PDFs
Validar formatos y resultados
Ajustar detalles visuales

Jorge y Baqueiro - Documentación (3h)
Documentar lo que haga falta
