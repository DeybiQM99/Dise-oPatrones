/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

/**
 *
 * @author carlo
 */
public class Empleado {
    private int IdEmpleado;
    private int IdTipoUsuario;
    private String Descripcion;
    private String Usuario;
    private String Nombre;
    private String Apellido;
    private String Contrasenia;

    public Empleado(int IdEmpleado, int IdTipoUsuario, String Descripcion, String Usuario, String Nombre, String Apellido, String Contrasenia) {
        this.IdEmpleado = IdEmpleado;
        this.IdTipoUsuario = IdTipoUsuario;
        this.Descripcion = Descripcion;
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Contrasenia = Contrasenia;
    }

    public Empleado(int IdEmpleado, String Descripcion, String Usuario) {
        this.IdEmpleado = IdEmpleado;
        this.Descripcion = Descripcion;
        this.Usuario = Usuario;
    }

    
    
    public Empleado() {
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdTipoUsuario() {
        return IdTipoUsuario;
    }

    public void setIdTipoUsuario(int IdTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

   @Override
    public String toString() {
        return IdEmpleado + " " + Usuario+" "+Descripcion;
    }
    

    
   
    
}
