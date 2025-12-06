Sprint Planning - Sistema de Control de Personal
Sprint Goal
"Completar el CRUD de empleados y agregar capacidad de exportación a PDF"

Historias de Usuario Seleccionadas
HU-03: Editar Empleados Prioridad: Alta Story Points: 3 Como administrador quiero modificar la información de un empleado existente para mantener actualizada su información
Criterios de Aceptación: 
Permite seleccionar un empleado de la lista
Permite modificar nombre, cargo y salario por hora
Actualiza la lista con la información modificada

HU-04: Eliminar empleados Prioridad: Media Story Points: 2 Como administrador quiero eliminar empleados del sistema para mantener limpia la base de datos

Criterios de Aceptación:
Permite seleccionar un empleado para eliminar
Muestra mensaje de confirmación antes de eliminar
Elimina solo si el usuario confirma
Actualiza automáticamente la lista
Muestra mensaje de éxito

HU-06: Exportar lista de Empleados a PDF 
Criterios de Aceptación: Genera archivo PDF con todos los empleados Incluye título "Lista de Empleados" y tabla formateada Incluye columnas: DPI, Nombre, Cargo y Salario/Hora Guarda con nombre "lista_empleados.pdf" Muestra mensaje de confirmación

Total Story Points del Sprint: 8

Estimaciones
gui_main.py                                                                        90 min Jorge
[HU-03] Implementar edición de empleados
[HU-03] Implementar eliminación de empleados                                   90 min Baqueiro
[HU-04] Incluir exportación de lista de empleados a PDF                      90 min Luis


