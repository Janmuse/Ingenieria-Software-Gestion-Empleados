Sprint Planning - Sistema de Control de Personal 
Sprint Goal Agregar el sistema de gestión de asistencia con registro de entrada/salida, generación de reportes completos y sistema de respaldos

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

HU-11: Restaurar Respaldo Prioridad: Baja Story Points: 3 Como administrador Quiero restaurar desde un archivo de respaldo para recuperar información en caso de errores

Criterios de Aceptación: 
Permite seleccionar archivo JSON de respaldos
Limpia la colección antes de restaurar 
Inserta datos del respaldo en MongoDB 

Comparación Planeado /Logrado 
HU-07: Registrar Entrada y Salida
Que se pudieran registrar los empleados y tomar en cuenta diferentes días / Se logró
HU-08: Generar Reporte de Horas Trabajadas
Permite registrar horas con el tipo de días que después calculan la paga del empleado en base a su salario por hora y si son horas
extras. Además permite seleccionar un empleado para generar un reporte detallado en una determinada escala de tiempo de sus horas
trabajadas con su salario / Increiblemente se logró
HU-09: Exportar Reporte Detallado a PDF 
Permite exportar la información a un reporte detallado en PDF de los pagos de los empleados con un botón/ Se logró
HU-10: Realizar Respaldo de Base de Datos
Permite generar un respaldo en formato JSON de los datos  / Se logró
HU-11: Restaurar Respaldo de Base de Datos
Permite recuperar la información del respaldo / Se logró

Evidencias del incremento funcional
Prueba de registrar empleado (día normal)
https://github.com/user-attachments/assets/a24b37b2-6759-4b37-ad59-616c6069f2b2
Prueba de registrar empleado(día festivo)
https://github.com/user-attachments/assets/ec5eb338-05ff-4acf-bfe0-f8424b85777b
Prueba de registrar empleado(día descanso)
https://github.com/user-attachments/assets/0939892a-ec2f-4312-96d6-4698bf34d84d
Prueba generar reporte mensual
https://github.com/user-attachments/assets/4c54133c-e0d5-4cd3-93a6-61fb75cfb47f
Prueba generar reporte mensual como PDF
https://github.com/user-attachments/assets/8da6f94a-da31-49a7-890f-40faa9065f62
Prueba generar respaldo
https://github.com/user-attachments/assets/142a0df9-8355-46b1-9a2b-024d4dde8886
Prueba restaurar respaldo
https://github.com/user-attachments/assets/a4f51ccd-ae73-49b7-8884-55183281ee06

Retrospectiva del Product Owner:
Ahora que tuvimos más tiempo pudimos ponernos metas más ambiciosas y alcanzarlas, le agradezco a todos los integrantes del equipo por su colaboración, si faltara aunque sea un solo miembro esto no sería posible


