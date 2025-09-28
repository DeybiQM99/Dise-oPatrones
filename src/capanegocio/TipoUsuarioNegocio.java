/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.TipoUsuarioDAO;
import capaentidades.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class TipoUsuarioNegocio {

    private final TipoUsuarioDAO datos;
    private DefaultTableModel modelotabla;

    public TipoUsuarioNegocio() {
        this.datos = new TipoUsuarioDAO();
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
        if (datos.insertar(p)) {
            return "Registro insertado exitosamente";
        } else {
            return "Registro insertado no exitoso";
        }
    }

    public String actualizar(TipoUsuario p) {
        if (datos.actualizar(p)) {
            return "actualizado exitosamente";
        } else {
            return "actualizado no exitoso";
        }
    }

    public String eliminar(TipoUsuario p) {
        if (datos.eliminar(p)) {
            return "Eliminado exitosamente";
        } else {
            return "Eliminado no exitoso";
        }
    }

}
