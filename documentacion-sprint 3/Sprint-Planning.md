Sprint Planning - Sistema de Control de Personal 
Sprint Goal Agregar el sistema de gestión de asistencia con registro de entrada/salida, generación de reportes
completos y sistema de respaldos

Historias de usuario seleccionadas: 
HU-07: Registrar Entrada y Salida Prioridad: Alta Story Points: 8 Como supervisor o administrador quiero registrar entrada y salida de empleados Para llevar control de asistencia y calcular horas trabajadas

Criterios de Aceptación: Permite seleccionar empleado de la lista Permite seleccionar fecha con calendario visual Permite ingresar hora de entrada y salida en formato HH:MM 
Calcula automáticamente horas normales (máx 8) y extras Permite seleccionar tipo de día (Normal, Festivo, Descanso) Calcula pago según tipo de día y tarifas Guarda registro en MongoDB

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


