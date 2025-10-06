/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.TipoUsuarioInface; // nombre original en tu proyecto
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TipoUsuarioNegocio {

    private final TipoUsuarioInface datos;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public TipoUsuarioNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (para tests o cambiar DB)
     */
    public TipoUsuarioNegocio(DAOFactory factory) {
        this.datos = factory.getTipoUsuarioDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<TipoUsuario> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{"ID", "Descripcion"};
        String[] fila = new String[2];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (TipoUsuario item : lista) {
            fila[0] = Integer.toString(item.getIdTipoUsuario());
            fila[1] = item.getDescripcion();
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(TipoUsuario p) {
        return datos.insertar(p)
                ? "Registro insertado exitosamente"
                : "Registro insertado no exitoso";
    }

    public String actualizar(TipoUsuario p) {
        return datos.actualizar(p)
                ? "Actualizado exitosamente"
                : "Actualización no exitosa";
    }

    public String eliminar(TipoUsuario p) {
        return datos.eliminar(p)
                ? "Eliminado exitosamente"
                : "Eliminación no exitosa";
    }
}
