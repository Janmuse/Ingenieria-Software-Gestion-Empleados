Historias completadas 
HU-01: Inicio de Sesión en el Sistema Prioridad: Alta Story Points: 3 Como administrador/supervisor/empleado Quiero iniciar sesión con mi usuario y contraseña Para acceder al sistema según mi rol y permisos asignados

Criterios de Aceptación: 
El sistema debe validar que el usuario y contraseña sean correctos antes de permitir el acceso
El sistema debe mostrar un mensaje de error cuando las credenciales sean incorrectas
El sistema debe redirigir al usuario al menú correspondiente según su rol (administrador, supervisor o empleado)
El sistema debe ocultar la contraseña mientras se escribe (mostrar asteriscos)

HU-05: Visualizar Lista de Empleados 
Prioridad: Alta 
Story Points: 3 
Como administrador quiero ver una lista completa de todos los empleados para consultar rápidamente su información

Criterios de Aceptación: 
Muestra tabla con todos los empleados registrados 
Incluye columnas: DPI, Nombre, Cargo y Salario por Hora Carga datos desde MongoDB 
Se actualiza automáticamente después de operaciones CRUD 
Muestra datos de forma clara y organizada

HU-02: Agregar Empleados 
Prioridad: Alta 
Story Points: 5 
Como administrador quiero agregar nuevos empleados al sistema para mantener actualizada la base de datos del personal

Criterios de Aceptación: 
Permite ingresar nombre, DPI, cargo y salario por hora Valida que todos los campos obligatorios estén completos Valida que el salario sea un número válido 
Muestra mensaje de confirmación al agregar exitosamente Actualiza automáticamente la lista de empleados

HU-12: Control de Acceso por Roles 
Prioridad: Alta 
Story Points: 5 
Como desarrollador del sistema quiero implementar control de acceso basado en roles para que cada usuario acceda solo a funciones permitidas
Criterios de Aceptación: 
Rol "administrador" tiene acceso completo 
Rol "supervisor" accede a registro y reportes 
Rol "empleado" accede solo a reportes 
Muestra solo botones permitidos según rol Valida rol antes de ejecutar acciones

Comparación  Planeado /Logrado
HU-12: Control de Roles | Completada, se tienen 3 roles
HU-05: Visualizar Lista | Completada , se actualiza después de operaciones y se puede ver
HU-02: Agregar Empleados | Completada, se pueden agregar nuevos empleados en la base de datos

Evidencias del incremento funcional

1 Menu del login
<img width="646" height="433" alt="Captura de pantalla 2025-12-04 230853" src="https://github.com/user-attachments/assets/8fcba917-1722-4c56-912f-9752532ee9f8" />
2 Menu Admin
<img width="852" height="567" alt="image" src="https://github.com/user-attachments/assets/6b0d598d-4899-4a47-8dfc-c973820bce55" />
3 Menu Supervisor 
<img width="1174" height="648" alt="image" src="https://github.com/user-attachments/assets/fdd29c57-3dd8-46c9-9c4c-822f0d2420eb" />
4 Menu Empleado
<img width="1057" height="767" alt="image" src="https://github.com/user-attachments/assets/ba4bc16a-4ee6-4ca9-9433-67260905555e" />
5 Se muestra la lista de empleados
<img width="978" height="682" alt="image" src="https://github.com/user-attachments/assets/4200364f-8fc0-4137-bf04-37a46d132659" />
6 Menu agregar empleados
<img width="943" height="634" alt="image" src="https://github.com/user-attachments/assets/6d481a37-66f3-4afa-98bf-ee11b7e421a1" />
7 Popup en agregar exitosamente
<img width="1340" height="733" alt="image" src="https://github.com/user-attachments/assets/c4f11acd-d5f3-4223-ab60-b3161f7176e1" />
8 Popup placeholder para registrar entrada/salida
<img width="834" height="568" alt="image" src="https://github.com/user-attachments/assets/096dddf1-c35a-43c5-a305-ed830115ea88" />
9 Popup placeholder para generar reporte mensual
<img width="877" height="534" alt="image" src="https://github.com/user-attachments/assets/2379fa1c-a37f-4371-bbd0-6c9ac7918c80" />
10 Ingresar datos equivocados 
<img width="542" height="448" alt="image" src="https://github.com/user-attachments/assets/bed32b6d-1035-4e54-a824-5d683ccd81d7" />
https://github.com/user-attachments/assets/7257592a-1284-4197-951a-29b4f639ea13
11 Prueba
https://github.com/user-attachments/assets/48caad4e-9317-412b-a0f1-9eb6f876ce9a

Feedback del Product Owner
Este primer sprint fue complicado ya que era la primera vez que trabajamos con esta metodología pero espero que podamos ir mejorando, el resultado técnico es bueno


