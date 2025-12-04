HU-01: Inicio de Sesión en el Sistema
Prioridad: Alta
Story Points: 3
Como administrador/supervisor/empleado
Quiero iniciar sesión con mi usuario y contraseña
Para acceder al sistema según mi rol y permisos asignados

Criterios de Aceptación:
El sistema debe validar que el usuario y contraseña sean correctos antes de permitir el acceso
El sistema debe mostrar un mensaje de error cuando las credenciales sean incorrectas
El sistema debe redirigir al usuario al menú correspondiente según su rol (administrador, supervisor o empleado)
El sistema debe ocultar la contraseña mientras se escribe (mostrar asteriscos)

HU-02: Agregar Empleados
Prioridad: Alta
Story Points: 5
Como administrador
Quiero agregar nuevos empleados al sistema
Para mantener actualizada la base de datos del personal

Criterios de Aceptación:
Permite ingresar nombre, DPI, cargo y salario por hora
Valida que todos los campos obligatorios estén completos
Valida que el salario sea un número válido
Muestra mensaje de confirmación al agregar exitosamente
Actualiza automáticamente la lista de empleados


HU-03: Editar Empleados
Prioridad: Alta
Story Points: 3
Como administrador
Quiero modificar la información de un empleado existente
Para mantener actualizada su información

Criterios de Aceptación:
Permite seleccionar un empleado de la lista
Carga automáticamente los datos actuales en el formulario
Permite modificar nombre, cargo y salario por hora
Guarda los cambios y muestra confirmación
Actualiza la lista con la información modificada


HU-04: Eliminar Empleados
Prioridad: Media
Story Points: 2
Como administrador
Quiero eliminar empleados del sistema
Para mantener limpia la base de datos

Criterios de Aceptación:
Permite seleccionar un empleado para eliminar
Muestra mensaje de confirmación antes de eliminar
Elimina solo si el usuario confirma
Actualiza automáticamente la lista
Muestra mensaje de éxito


HU-05: Visualizar Lista de Empleados
Prioridad: Alta
Story Points: 3
Como administrador
Quiero ver una lista completa de todos los empleados
Para consultar rápidamente su información

Criterios de Aceptación:
Muestra tabla con todos los empleados registrados
Incluye columnas: DPI, Nombre, Cargo y Salario por Hora
Carga datos desde MongoDB
Se actualiza automáticamente después de operaciones CRUD
Muestra datos de forma clara y organizada

HU-06: Exportar Lista de Empleados a PDF
Prioridad: Baja
Story Points: 3
Como administrador
Quiero exportar la lista de empleados a PDF
Para generar reportes físicos o compartirlos

Criterios de Aceptación:
Genera archivo PDF con todos los empleados
Incluye título "Lista de Empleados" y tabla formateada
Incluye columnas: DPI, Nombre, Cargo y Salario/Hora
Guarda con nombre "lista_empleados.pdf"
Muestra mensaje de confirmación


HU-07: Registrar Entrada y Salida
Prioridad: Alta
Story Points: 8
Como supervisor o administrador
Quiero registrar entrada y salida de empleados
Para llevar control de asistencia y calcular horas trabajadas

Criterios de Aceptación:
Permite seleccionar empleado de la lista
Permite seleccionar fecha con calendario visual
Permite ingresar hora de entrada y salida en formato HH:MM
Calcula automáticamente horas normales (máx 8) y extras
Permite seleccionar tipo de día (Normal, Festivo, Descanso)
Calcula pago según tipo de día y tarifas
Guarda registro en MongoDB


HU-08: Generar Reporte de Horas Trabajadas
Prioridad: Alta
Story Points: 8
Como empleado, supervisor o administrador
Quiero generar reportes de horas trabajadas por período
Para revisar tiempo laborado y pagos

Criterios de Aceptación:
Permite seleccionar empleados individuales o todos
Permite seleccionar rango: Día, Semana o Mes
Permite ingresar fecha o período para filtrar
Calcula totales: horas normales, extras y pago
Muestra resultados en tabla organizada
Permite reportes de uno o múltiples empleados


HU-09: Exportar Reporte Detallado a PDF
Prioridad: Media
Story Points: 5
Como administrador o supervisor
Quiero exportar reportes detallados a PDF
Para archivar documentos de nómina

Criterios de Aceptación:
Genera PDF con título "Reporte Detallado de Horas Trabajadas"
Incluye tabla resumen con totales por empleado
Incluye detalles de cada registro individual por empleado
Guarda como "reporte_personal_detallado.pdf"
Muestra mensaje de confirmación


HU-10: Realizar Respaldo de Base de Datos
Prioridad: Media
Story Points: 5
Como administrador
Quiero realizar respaldos automáticos
Para proteger la información del sistema

Criterios de Aceptación:
Crea respaldos en JSON de las colecciones
Guarda en carpeta "respaldos" con fecha y hora
Mantiene solo los 3 respaldos más recientes
Elimina automáticamente respaldos antiguos
Muestra mensaje de confirmación


HU-11: Restaurar Respaldo
Prioridad: Baja
Story Points: 3
Como administrador
Quiero restaurar desde un archivo de respaldo
Para recuperar información en caso de errores

Criterios de Aceptación:
Permite seleccionar archivo JSON de respaldos
Limpia la colección antes de restaurar
Inserta datos del respaldo en MongoDB
Actualiza la interfaz automáticamente
Muestra mensaje de éxito o error


HU-12: Control de Acceso por Roles
Prioridad: Alta
Story Points: 5
Como desarrollador del sistema
Quiero implementar control de acceso basado en roles
Para que cada usuario acceda solo a funciones permitidas

Criterios de Aceptación:
Rol "administrador" tiene acceso completo
Rol "supervisor" accede a registro y reportes
Rol "empleado" accede solo a reportes
Muestra solo botones permitidos según rol
Valida rol antes de ejecutar acciones

