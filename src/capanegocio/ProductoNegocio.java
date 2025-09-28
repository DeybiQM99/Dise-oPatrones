/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.CategoriaDAO;
import capadatos.ProductoDAO;
import capaentidades.Categoria;

import capaentidades.Producto;
import capaentidades.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class ProductoNegocio {
    
    private final ProductoDAO datos;
    private final CategoriaDAO datoscate;
    private DefaultTableModel modelotabla;
    public ProductoNegocio() {
        this.datos = new ProductoDAO();
        this.datoscate=new CategoriaDAO();
    }
    
    
    public DefaultTableModel listar(String texto){
      List<Producto> lista = new ArrayList<>();
         lista.addAll(datos.listar(texto));
        String[] columnas = new String[]{"Idproducto ", "Idcategoria ","Nombre categoria "," Nombre de producto ", "Descripcion ", "Precio","Stock "};
        String[] fila = new String[7];
        this.modelotabla = new DefaultTableModel(null, columnas);
        for (Producto item : lista) {
        fila[0] = Integer.toString(item.getIdProducto());
        fila[1] = Integer.toString(item.getIdCategoria());
        fila[2] = item.getNombrecategoria();
        fila[3] = item.getNombre();
        fila[4] = item.getDescripcion();
        fila[5] = Double.toString(item.getPrecio());
        fila[6] = Integer.toString(item.getStock());
        this.modelotabla.addRow(fila);
        }
        return modelotabla;
    
    }
     public String insertar(Producto E) {
        if (datos.insertar(E)) {
            return "Registro insertado exitosamente";
        } else {
            return "Registro insertado no exitoso";
        }
    }

    public String actualizar(Producto E) {
        if (datos.actualizar(E)) {
            return "actualizado exitosamente";
        } else {
            return "actualizado no exitoso";
        }
    }

    public String eliminar(Producto E) {
        if (datos.eliminar(E)) {
            return "Eliminado exitosamente";
        } else {
            return "Eliminado no exitoso";
        }
    }
    
    
      public DefaultComboBoxModel seleccionar1() {
    DefaultComboBoxModel items = new DefaultComboBoxModel();
    List<Categoria> lista = datoscate.seleccionar(); 

    for (Categoria item : lista) {
        Categoria med = new Categoria(
            item.getIdcategoria(),
            item.getNombre()
        );
        items.addElement(med);
    }

    return items;
}
      
   public List<Producto> listar1() {
        return datos.listarTodos();
    }
    
    
    
}
