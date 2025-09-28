/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.PagoDAO;
import capaentidades.Pago;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PagoNegocio {
    private final PagoDAO datos;
    private DefaultTableModel modelotabla;

    public PagoNegocio() {
        this.datos = new PagoDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Pago> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{
            "IdPago", "Método", "Monto", "Fecha", "Hora"
        };
        String[] fila = new String[5];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (Pago item : lista) {
            fila[0] = Integer.toString(item.getIdPago());
            fila[1] = item.getMetodo();
            fila[2] = Double.toString(item.getMonto());
            fila[3] = item.getFecha().toString(); // java.sql.Date → String
            fila[4] = item.getHora().toString();  // java.sql.Time → String
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(Pago p) {
        if (datos.insertar(p)) {
            return "Pago registrado exitosamente";
        } else {
            return "Error: el pago no pudo registrarse";
        }
    }

    public String actualizar(Pago p) {
        if (datos.actualizar(p)) {
            return "Pago actualizado exitosamente";
        } else {
            return "Error: el pago no pudo actualizarse";
        }
    }

    public String eliminar(Pago p) {
        if (datos.eliminar(p)) {
            return "Pago eliminado exitosamente";
        } else {
            return "Error: el pago no pudo eliminarse";
        }
    }
    
       public int insertarID(Pago p) {
        return datos.insertarID(p);
    }
}
