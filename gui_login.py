# gui_login.py
usuario_entry = tk.Entry(ventana_login, font=("Arial", 12))
password_entry = tk.Entry(ventana_login, show="*", font=("Arial", 12))  

def iniciar_sesion():
    usuario = usuario_entry.get().strip()
    contraseña = password_entry.get().strip()

    rol = validar_credenciales(usuario, contraseña)
    if rol:
        ventana_login.destroy()
        app_root.rol_usuario = rol
        app_root.mostrar_menu_principal(rol)  # ✅ Llamamos al método de la clase App
    else:
        messagebox.showerror("Error", "Usuario o contraseña incorrectos.")
