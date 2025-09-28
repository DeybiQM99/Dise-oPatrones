/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

/**
 *
 * @author carlo
 */
public class TipoUsuario {
    
    private int IdTipoUsuario;
    private String Descripcion;

    public TipoUsuario(int idTipoUsuario, String descripcion) {
        IdTipoUsuario = idTipoUsuario;
        Descripcion = descripcion;
    }

    public TipoUsuario() {
    }

    public int getIdTipoUsuario() {
        return IdTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        IdTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return IdTipoUsuario+". "+Descripcion; 
    }
    
    
    
}
