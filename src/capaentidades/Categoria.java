/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

/**
 *
 * @author carlo
 */
public class Categoria {
    
    private int Idcategoria;
    private String nombre;

    public Categoria(int Idcategoria, String nombre) {
        this.Idcategoria = Idcategoria;
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public int getIdcategoria() {
        return Idcategoria;
    }

    public void setIdcategoria(int Idcategoria) {
        this.Idcategoria = Idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     @Override
    public String toString() {
        return Idcategoria+". "+nombre; 
    }
    
    
    
    
    
}
