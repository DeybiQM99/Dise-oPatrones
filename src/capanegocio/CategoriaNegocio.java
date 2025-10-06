/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.CategoriaInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaNegocio {

    private final CategoriaInterface datos;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public CategoriaNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor inyectando la fábrica (útil para pruebas o cambiar motor)
     */
    public CategoriaNegocio(DAOFactory factory) {
        this.datos = factory.getCategoriaDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Categoria> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{"Id categoria", "Nombre"};
        String[] fila = new String[2];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (Categoria item : lista) {
            fila[0] = Integer.toString(item.getIdcategoria());
            fila[1] = item.getNombre();
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(Categoria c) {
        if (datos.insertar(c)) {
            return "Registro insertado exitosamente";
        } else {
            return "Registro insertado no exitoso";
        }
    }

    public String actualizar(Categoria p) {
        if (datos.actualizar(p)) {
            return "actualizado exitosamente";
        } else {
            return "actualizado no exitoso";
        }
    }

    public String eliminar(Categoria p) {
        if (datos.eliminar(p)) {
            return "Eliminado exitosamente";
        } else {
            return "Eliminado no exitoso";
        }
    }

}
