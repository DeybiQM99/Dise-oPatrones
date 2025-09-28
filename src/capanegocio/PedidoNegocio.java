/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.PedidoDAO;
import capaentidades.Pedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class PedidoNegocio {
      private final PedidoDAO datos;
    private DefaultTableModel modelotabla;

    public PedidoNegocio() {
        this.datos = new PedidoDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Pedido> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{
            "IdPedido", "Numero de Pedido", "Hora", "Fecha", "Estado"
        };
        String[] fila = new String[5];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (Pedido item : lista) {
            fila[0] = Integer.toString(item.getIdPedido());
            fila[1] = item.getNumeroDePedido();
            fila[2] = item.getHora().toString();   // 👈 convertir Time a String (ej: "14:30:00")
          fila[3] = item.getFecha().toString(); 
            fila[4] = item.getEstado();
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(Pedido p) {
        if (datos.insertar(p)) {
            return "Registro insertado exitosamente";
        } else {
            return "Registro insertado no exitoso";
        }
    }

    public String actualizar(Pedido p) {
        if (datos.actualizar(p)) {
            return "Actualizado exitosamente";
        } else {
            return "Actualización no exitosa";
        }
    }

    public String eliminar(Pedido p) {
        if (datos.eliminar(p)) {
            return "Eliminado exitosamente";
        } else {
            return "Eliminación no exitosa";
        }
    }
    
    public String insertarAutomatico(Pedido p) {
        Pedido nuevo = datos.generarPedidoAutomatico(); 
        nuevo.setEstado(p.getEstado());                 

        if (datos.insertar(nuevo)) {
            return "Pedido insertado exitosamente con número: " + nuevo.getNumeroDePedido();
        } else {
            return "Error al insertar pedido";
        }
    }
  // Método para generar un Pedido automático
    public Pedido generarAutomatico() {
        Pedido p = new Pedido();

        // Generar número de pedido único: PED + fecha + hora
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String numero = "PED" + sdf.format(new java.util.Date());
        p.setNumeroDePedido(numero);

        // Fecha y hora actuales
        java.util.Date ahora = new java.util.Date();
        p.setFecha(new java.sql.Date(ahora.getTime()));
        p.setHora(new java.sql.Time(ahora.getTime()));

        // Estado por defecto
        p.setEstado("En preparacion");

        return p;
    }
    
    public int insertarID(Pedido p) {
    int id = datos.insertarID(p);
    return id; 
    }
    
   
}
