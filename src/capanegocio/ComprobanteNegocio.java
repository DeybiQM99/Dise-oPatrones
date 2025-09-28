/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.ComprobanteDAO;
import capadatos.EmpleadoDAO;
import capaentidades.Comprobante;
import capaentidades.Empleado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class ComprobanteNegocio {
    private final EmpleadoDAO datos;
    private final ComprobanteDAO datoscom;
    
     private DefaultTableModel modelotabla;
     private final ComprobanteDAO datosdj;
    public ComprobanteNegocio() {
        this.datos = new EmpleadoDAO();
        this.datosdj= new ComprobanteDAO();
        this.datoscom= new ComprobanteDAO();
    }
    

    public String insertar(Comprobante c) {
        if (datosdj.insertar(c)) {
            return "Comprobante insertado exitosamente";
        } else {
            return "No se pudo insertar el comprobante";
        }
    }
    
    public DefaultComboBoxModel seleccionar1() {
    DefaultComboBoxModel items = new DefaultComboBoxModel();
    List<Empleado> lista = datos.seleccionar(); // Usa tu método seleccionar() de Empleado

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
    
    
     public int insertarID(Comprobante comp) {
        return datosdj.insertarID(comp);
    }
     
        public String generarNumero() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int secuencia = new Random().nextInt(900) + 100; // 100 a 999
        return " " + fecha + "-" + secuencia;
    }

    // Generar código automático numérico de 6 dígitos
    public String generarCodigo() {
        int codigo = new Random().nextInt(152) + 10; // 
        return String.valueOf(codigo);
    }
     
      public Comprobante generarAutomatico(String tipo) {
        Comprobante comp = new Comprobante();

        // Número correlativo según tipo
        int ultimo = datoscom.obtenerUltimoNumero(tipo);
        int nuevo = ultimo + 1;

        if (tipo.equalsIgnoreCase("Boleta")) {
            comp.setNumero("B-" + String.format("%06d", nuevo));
        } else if (tipo.equalsIgnoreCase("Factura")) {
            comp.setNumero("F-" + String.format("%06d", nuevo));
        } else {
            comp.setNumero("X-" + String.format("%06d", nuevo));
        }

        // Código aleatorio de 6 dígitos
        comp.setCodigo(generarCodigo());

        return comp;
    }

    private String generarCodigo1() {
        int codigo = new Random().nextInt(15) + 400; // 100000 - 999999
        return String.valueOf(codigo);
    }


    



     

        
    
    
}
