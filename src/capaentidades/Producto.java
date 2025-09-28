/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;


public class Producto {
    
    
 private int   IdProducto;
    private int IdCategoria; 
    private String nombrecategoria;
 private String Nombre; 
 private String Descripcion; 
 private Double Precio; 
 private int Stock; 

    public Producto(int IdProducto, String Nombre) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
    }
 
 
 
 
    public Producto(int IdProducto, int IdCategoria, String nombrecategoria, String Nombre, String Descripcion, Double Precio, int Stock) {
        this.IdProducto = IdProducto;
        this.IdCategoria = IdCategoria;
        this.nombrecategoria = nombrecategoria;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Stock = Stock;
    }
    public Producto() {
        
    }
    

    
    
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

 
 
    @Override
    public String toString() {
        return IdProducto+" "+Nombre; 
    }
    
    
    
    
}
