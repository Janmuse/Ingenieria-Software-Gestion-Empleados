# gui_main.py
import tkinter as tk
from tkinter import ttk, messagebox
from conexion.conexion_mongo import ConexionMongoDB
from clases.empleado import Empleado


class App(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Sistema de Control de Personal")
        self.geometry("800x500")
        self.resizable(False, False)
        self.configure(bg="#f2f2f2")
        
        # Estilo moderno
        self.style = ttk.Style()
        self.style.theme_use('clam')
        self.style.configure("TButton", padding=10, relief="flat",
                             background="#4CAF50", foreground="white", font=("Arial", 12))
        self.style.map("TButton", background=[("active", "#45a049")])
        self.style.configure("Treeview.Heading", font=("Arial", 12, "bold"))
        self.style.configure("Treeview", rowheight=25, font=("Arial", 11))

        # Variable para guardar el rol del usuario logueado
        self.rol_usuario = None
        self.withdraw()

    def mostrar_menu_principal(self, rol):
        """Muestra el menú principal según el rol"""
        self.withdraw()   # Ocultar la ventana de login
        self.deiconify() # Mostrar la ventana principal
        self.rol_usuario = rol
        self.create_widgets_with_role(rol)

    def create_widgets_with_role(self, rol):
        """Crea los widgets según el rol del usuario"""
        # Título principal
        title_label = tk.Label(self, text="Sistema de Control de Personal", font=("Arial", 16, "bold"),
                               bg="#f2f2f2", fg="#333")
        title_label.pack(pady=30)

        btn_frame = tk.Frame(self, bg="#f2f2f2")
        btn_frame.pack(pady=20)
        
        if rol == "administrador":
            ttk.Button(btn_frame, text="Gestionar Empleados", width=30,
                       command=self.abrir_gestion_empleados).grid(row=0, column=0, padx=10, pady=10)

        if rol in ["administrador", "supervisor"]:
            ttk.Button(btn_frame, text="Registrar Entrada/Salida", width=30,
                       command=self.placeholder_registro).grid(row=1, column=0, padx=10, pady=10)

        if rol in ["administrador", "supervisor", "empleado"]:
            ttk.Button(btn_frame, text="Generar Reporte Mensual", width=30,
                       command=self.placeholder_reporte).grid(row=2, column=0, padx=10, pady=10)
    
        ttk.Button(btn_frame, text="Salir", width=30, 
                   command=self.destroy).grid(row=3, column=0, padx=10, pady=10)

    def abrir_gestion_empleados(self):
        ventana_lista = tk.Toplevel(self)
        ventana_lista.title("Lista de Empleados")
        ventana_lista.geometry("900x600")
        ventana_lista.configure(bg="#ffffff")

        tk.Label(ventana_lista, text="Lista de Empleados", font=("Arial", 14, "bold"), bg="#ffffff").pack(pady=10)

        btn_frame = tk.Frame(ventana_lista, bg="#ffffff")
        btn_frame.pack(pady=10)

        btn_agregar = ttk.Button(btn_frame, text="Agregar Empleado", width=25, 
                                 command=self.agregar_empleado)
        btn_eliminar = ttk.Button(btn_frame, text="Eliminar Seleccionado", width=25, command=self.eliminar_empleado)
        btn_agregar.grid(row=0, column=0, padx=10)
        btn_eliminar.grid(row=0, column=1, padx=10)


        #Tabla de empleados
        self.tree = ttk.Treeview(ventana_lista,
                                 columns=("DPI", "Nombre", "Cargo", "Salario/Hora"),
                                 show="headings", height=20)
        self.tree.heading("DPI", text="DPI")
        self.tree.heading("Nombre", text="Nombre")
        self.tree.heading("Cargo", text="Cargo")
        self.tree.heading("Salario/Hora", text="Salario por Hora")

        self.tree.column("DPI", width=150, anchor="center")
        self.tree.column("Nombre", width=250, anchor="w")
        self.tree.column("Cargo", width=250, anchor="w")
        self.tree.column("Salario/Hora", width=150, anchor="e")

        self.tree.pack(padx=20, pady=10, fill="both", expand=True)

        self.cargar_empleados()

    def cargar_empleados(self):
        """Carga los empleados desde MongoDB"""
        for item in self.tree.get_children():
            self.tree.delete(item)

        conexion = ConexionMongoDB()
        empleados_collection = conexion.get_collection("empleados")
        empleados = list(empleados_collection.find())

        for emp in empleados:
            self.tree.insert("", tk.END, values=(
                emp["dpi"],
                emp["nombre"],
                emp["cargo"],
                f"${emp['salario_hora']:.2f}"
            ))

    def agregar_empleado(self):
        self.abrir_formulario_edicion()
    
    def eliminar_empleado(self):
        selected = self.tree.focus()
        if not selected:
            messagebox.showwarning("Seleccionar", "Por favor, seleccione un empleado.")
            return

        valores = self.tree.item(selected, 'values')
        dpi_seleccionado = valores[0]

        if messagebox.askyesno("Eliminar", f"¿Está seguro de eliminar a {valores[1]}?"):
            conexion = ConexionMongoDB()
            empleados = conexion.get_collection("empleados")
            empleados.delete_one({"dpi": dpi_seleccionado})
            self.cargar_empleados()
            messagebox.showinfo("Éxito", "Empleado eliminado correctamente.")

    def abrir_formulario_edicion(self, dpi=None):
        ventana = tk.Toplevel(self)
        ventana.title("Agregar Empleado")
        ventana.geometry("500x400")
        ventana.configure(bg="#ffffff")

        tk.Label(ventana, text="Nombre:", font=("Arial", 12), bg="#ffffff").pack(pady=5)
        nombre_entry = tk.Entry(ventana, font=("Arial", 12))
        nombre_entry.pack(pady=5)

        tk.Label(ventana, text="DPI:", font=("Arial", 12), bg="#ffffff").pack(pady=5)
        dpi_entry = tk.Entry(ventana, font=("Arial", 12))
        dpi_entry.pack(pady=5)

        tk.Label(ventana, text="Cargo:", font=("Arial", 12), bg="#ffffff").pack(pady=5)
        cargo_entry = tk.Entry(ventana, font=("Arial", 12))
        cargo_entry.pack(pady=5)

        tk.Label(ventana, text="Salario por hora:", font=("Arial", 12), bg="#ffffff").pack(pady=5)
        salario_entry = tk.Entry(ventana, font=("Arial", 12))
        salario_entry.pack(pady=5)

        def guardar():
            nombre = nombre_entry.get()
            dpi = dpi_entry.get()
            cargo = cargo_entry.get()
            
            if not all([nombre, dpi, cargo]):
                messagebox.showerror("Error", "Complete todos los campos.")
                return
            
            try:
                salario = float(salario_entry.get())
            except ValueError:
                messagebox.showerror("Error", "Ingrese un salario válido.")
                return

            empleado = Empleado(nombre, dpi, cargo, salario)

            conexion = ConexionMongoDB()
            empleados = conexion.get_collection("empleados")
            
            empleados.insert_one(empleado.to_dict())
            
            messagebox.showinfo("Éxito", "Empleado agregado correctamente.")

            self.cargar_empleados()
            ventana.destroy()

        ttk.Button(ventana, text="Guardar", command=guardar).pack(pady=20)
        
    def placeholder_registro(self):
        messagebox.showinfo("En desarrollo", 
                            "La funcionalidad de Registro de Entrada/Salida estará disponible próximamente.")

    def placeholder_reporte(self):
        messagebox.showinfo("En desarrollo", 
                            "La funcionalidad de Reportes Mensuales estará disponible próximamente.")


if __name__ == "__main__":
    app = App()
    app.withdraw() # Ocultar hasta que inicie sesión
    from gui_login import abrir_ventana_login
    abrir_ventana_login(app)
    app.mainloop()
