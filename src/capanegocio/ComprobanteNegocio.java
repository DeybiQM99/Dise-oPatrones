/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.EmpleadoInterface;
import capadatos.Interface.ComprobanteInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Comprobante;
import capaentidades.Empleado;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ComprobanteNegocio {

    private final EmpleadoInterface datosEmpleado;
    private final ComprobanteInterface datosComprobante;

    private DefaultTableModel modelotabla;

    /*Constructor por defecto: usa la fábrica POSTGRES*/
    public ComprobanteNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /*Constructor con inyección de fábrica (útil para tests/cambiar motor)*/
    public ComprobanteNegocio(DAOFactory factory) {
        this.datosEmpleado = factory.getEmpleadoDAO();
        this.datosComprobante = factory.getComprobanteDAO();
    }

    // Insertar comprobante
    public String insertar(Comprobante c) {
        if (datosComprobante.insertar(c)) {
            return "Comprobante insertado exitosamente";
        } else {
            return "No se pudo insertar el comprobante";
        }
    }

    // Insertar y devolver ID
    public int insertarID(Comprobante comp) {
        return datosComprobante.insertarID(comp);
    }

    // Llenar combo con empleados (usa método seleccionar() del DAO)
    public DefaultComboBoxModel seleccionar1() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Empleado> lista = datosEmpleado.seleccionar();

        for (Empleado item : lista) {
            Empleado emp = new Empleado(
                    item.getIdEmpleado(),
                    item.getDescripcion(),
                    item.getUsuario()
            );
            items.addElement(emp);
        }
        return items;
    }

    // Generar número con fecha + secuencia aleatoria
    public String generarNumero() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int secuencia = new Random().nextInt(900) + 100; // 100..999
        return " " + fecha + "-" + secuencia;
    }

    // Generar código aleatorio (puedes ajustar el rango si lo necesitas)
    public String generarCodigo() {
        int codigo = new Random().nextInt(152) + 10;
        return String.valueOf(codigo);
    }

    // Genera un comprobante con número correlativo por tipo + código aleatorio
    public Comprobante generarAutomatico(String tipo) {
        Comprobante comp = new Comprobante();

        int ultimo = datosComprobante.obtenerUltimoNumero(tipo);
        int nuevo = ultimo + 1;

        if (tipo.equalsIgnoreCase("Boleta")) {
            comp.setNumero("B-" + String.format("%06d", nuevo));
        } else if (tipo.equalsIgnoreCase("Factura")) {
            comp.setNumero("F-" + String.format("%06d", nuevo));
        } else {
            comp.setNumero("X-" + String.format("%06d", nuevo));
        }

        comp.setCodigo(generarCodigo());
        return comp;
    }

    // (Si no lo usas, puedes eliminarlo)
    private String generarCodigo1() {
        int codigo = new Random().nextInt(15) + 400;
        return String.valueOf(codigo);
    }

}
