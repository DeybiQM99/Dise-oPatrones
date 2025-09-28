/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

/**
 *
 * @author carlo
 */
public class Cliente {
     private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String razonSocial;
    private String ruc;

    // Constructor vacío (necesario para crear objetos sin datos)
    public Cliente() {
    }

    // Constructor con parámetros (para inicializar todo)
    public Cliente(int idCliente, String nombre, String apellido, String dni, 
                   String telefono, String direccion, String razonSocial, String ruc) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    // Para mostrar el nombre en un JComboBox o debug
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    
    
}
