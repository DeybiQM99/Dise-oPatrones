/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.ProductoInterface;
import capadatos.Interface.CategoriaInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Categoria;
import capaentidades.Producto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ProductoNegocio {

    private final ProductoInterface datos;
    private final CategoriaInterface datoscate;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public ProductoNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (tests / otros motores)
     */
    public ProductoNegocio(DAOFactory factory) {
        this.datos = factory.getProductoDAO();
        this.datoscate = factory.getCategoriaDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Producto> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{
            "Idproducto ", "Idcategoria ", "Nombre categoria ", " Nombre de producto ", "Descripcion ", "Precio", "Stock "
        };
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

    public String insertar(Producto p) {
        return datos.insertar(p)
                ? "Registro insertado exitosamente"
                : "Registro insertado no exitoso";
    }

    public String actualizar(Producto p) {
        return datos.actualizar(p)
                ? "actualizado exitosamente"
                : "actualizado no exitoso";
    }

    public String eliminar(Producto p) {
        return datos.eliminar(p)
                ? "Eliminado exitosamente"
                : "Eliminado no exitoso";
    }

    // Combo de categorías
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

    // Listado simple de todos los productos (para combos u otros usos)
    public List<Producto> listar1() {
        return datos.listarTodos();
    }
    
}
