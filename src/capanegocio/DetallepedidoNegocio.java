/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;


import capadatos.PedidoDAO;
import capadatos.PedidoDetalleDAO;
import capadatos.ProductoDAO;
import capaentidades.Pedido;
import capaentidades.PedidoDetalle;
import capaentidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DetallepedidoNegocio {
    private final PedidoDetalleDAO datos2;
    private final ProductoDAO datospro;
    private final PedidoDAO datospedi;
    private DefaultTableModel modelotabla;

    public DetallepedidoNegocio() {
        this.datos2 = new PedidoDetalleDAO();
        this.datospro=new ProductoDAO();
        this.datospedi=new PedidoDAO();
    }

    // Listar con búsqueda por nombre de producto
    public DefaultTableModel listar(String texto) {
        List<PedidoDetalle> lista = new ArrayList<>();
        lista.addAll(datos2.listar(texto));

        String[] columnas = new String[]{
            "IdDetalle",
            "IdProducto",
            "IdPedido",
            "Numero de Pedido",
            "Nombre Producto",
            "Cantidad",
            "Precio Unitario",
            "Subtotal"
        };

        String[] fila = new String[8];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (PedidoDetalle item : lista) {
            fila[0] = Integer.toString(item.getIdDetalle());
            fila[1] = Integer.toString(item.getIdProducto());
            fila[2] = Integer.toString(item.getIdPedido());
            fila[3] = item.getNumeroDePedido();
            fila[4] = item.getNombreProducto();
            fila[5] = Integer.toString(item.getCantidad());
            fila[6] = Double.toString(item.getPrecioUnitario());
            fila[7] = Double.toString(item.getSubtotal());
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(PedidoDetalle d) {
        if (datos2.insertar(d)) {
            return "Registro insertado exitosamente";
        } else {
            return "Error al insertar el registro";
        }
    }

    public String actualizar(PedidoDetalle d) {
        if (datos2.actualizar(d)) {
            return "Registro actualizado exitosamente";
        } else {
            return "Error al actualizar el registro";
        }
    }

    public String eliminar(PedidoDetalle d) {
        if (datos2.eliminar(d)) {
            return "Registro eliminado exitosamente";
        } else {
            return "Error al eliminar el registro";
        } 
        }
    
    public DefaultComboBoxModel seleccionar1() {
    DefaultComboBoxModel ETEMS = new DefaultComboBoxModel();
    List<Producto> lista = datospro.seleccionar1(); 

    for (Producto etem : lista) {
        Producto med = new Producto(
            etem.getIdProducto(),
            etem.getNombre()
        );
        ETEMS.addElement(med);
    }

    return ETEMS;
}
    public DefaultComboBoxModel seleccionarpedido() {
    DefaultComboBoxModel items = new DefaultComboBoxModel();
    List<Pedido> lista = datospedi.seleccionar(); // tu método seleccionar()

    for (Pedido item : lista) {
        Pedido ped = new Pedido(
            item.getIdPedido(),
            item.getNumeroDePedido()
        );
        items.addElement(ped);
    }
    return items;
}
    

    public boolean insertardeta(PedidoDetalle d) {
        return datos2.insertardetalle(d);
    }
    }

