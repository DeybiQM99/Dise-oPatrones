/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Producto;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface ProductoInterface {
    public List<Producto> listar(String texto);
    public boolean insertar(Producto E);
     public boolean actualizar(Producto E);
     public boolean eliminar(Producto E);
      public List<Producto> seleccionar1();
}
