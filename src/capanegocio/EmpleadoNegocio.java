/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.EmpleadoInterface;
import capadatos.Interface.TipoUsuarioInface; // nombre tal cual en tu proyecto
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Empleado;
import capaentidades.TipoUsuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;

public class EmpleadoNegocio {

    private final EmpleadoInterface datos;
    private final TipoUsuarioInface datosusu;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public EmpleadoNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (tests / otros motores)
     */
    public EmpleadoNegocio(DAOFactory factory) {
        this.datos = factory.getEmpleadoDAO();
        this.datosusu = factory.getTipoUsuarioDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Empleado> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{"IdEmpleado ", "IdTipoUsuario ", "Descripcion", "Usuario ", "Nombre ", "Apellido", "Contrasenia "};
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
        return datos.insertar(p) ? "Registro insertado exitosamente" : "Registro insertado no exitoso";
    }

    public String actualizar(Empleado p) {
        return datos.actualizar(p) ? "actualizado exitosamente" : "actualizado no exitoso";
    }

    public String eliminar(Empleado p) {
        return datos.eliminar(p) ? "Eliminado exitosamente" : "Eliminado no exitoso";
    }

    // Combo: Tipos de usuario
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

    // Login básico
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
        return emp; // OK
    }
}
