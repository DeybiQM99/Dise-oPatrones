/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.EmpleadoDAO;
import capadatos.TipoUsuarioDAO;
import capaentidades.Empleado;
import capaentidades.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class EmpleadoNegocio {
    
    private final EmpleadoDAO datos;
    private DefaultTableModel modelotabla;
    private final TipoUsuarioDAO datosusu;
    public EmpleadoNegocio() {
        this.datos = new EmpleadoDAO();
        this.datosusu=new TipoUsuarioDAO();
        
    }
    
    
    public DefaultTableModel listar(String texto){
      List<Empleado> lista = new ArrayList<>();
         lista.addAll(datos.listar(texto));
        String[] columnas = new String[]{"IdEmpleado ", "IdTipoUsuario ","Descripcion","Usuario ", "Nombre ", "Apellido","Contrasenia "};
        String[] fila = new String[7];
        this.modelotabla = new DefaultTableModel(null, columnas);
        for (Empleado item : lista) {
        fila[0] = Integer.toString(item.getIdEmpleado());
        fila[1] = Integer.toString(item.getIdTipoUsuario());
        fila[2] = item.getDescripcion();
        fila[3] = item.getUsuario();
        fila[4] = item.getNombre();
        fila[5] = item.getApellido();
        fila[6] = item.getContrasenia();
        this.modelotabla.addRow(fila);
        }
        return modelotabla;
    
    }
    
    
    
    public int insertarID(Empleado e) {
        return datos.insertarID(e);
    }
    
    
    
     public String insertar(Empleado p) {
        if (datos.insertar(p)) {
            return "Registro insertado exitosamente";
        } else {
            return "Registro insertado no exitoso";
        }
    }

    public String actualizar(Empleado p) {
        if (datos.actualizar(p)) {
            return "actualizado exitosamente";
        } else {
            return "actualizado no exitoso";
        }
    }

    public String eliminar(Empleado p) {
        if (datos.eliminar(p)) {
            return "Eliminado exitosamente";
        } else {
            return "Eliminado no exitoso";
        }
    }
    
    
    
    public DefaultComboBoxModel seleccionar1() {
    DefaultComboBoxModel items = new DefaultComboBoxModel();
    List<TipoUsuario> lista = datosusu.seleccionar(); 

    for (TipoUsuario item : lista) {
        TipoUsuario med = new TipoUsuario(
            item.getIdTipoUsuario(),
            item.getDescripcion()
        );
        items.addElement(med);
    }

    return items;
}
     public Empleado validarLogin(String usuario, String contrasenia) {
        Empleado emp = datos.obtenerPorUsuario(usuario);

        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return null;
        }

        if (!emp.getContrasenia().equals(contrasenia)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            return null;
        }

        // Login exitoso, devuelve el empleado con su tipo
        return emp;
    }
    
}
