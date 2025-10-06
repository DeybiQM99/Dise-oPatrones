/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.DetalleInterface;
import capadatos.Interface.ProductoInterface;
import capadatos.Interface.PedidoInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Pedido;
import capaentidades.PedidoDetalle;
import capaentidades.Producto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DetallepedidoNegocio {

    private final DetalleInterface datosDetalle;
    private final ProductoInterface datosProducto;
    private final PedidoInterface datosPedido;

    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto (POSTGRES)
     */
    public DetallepedidoNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (tests, otros motores)
     */
    public DetallepedidoNegocio(DAOFactory factory) {
        this.datosDetalle = factory.getPedidoDetalleDAO();
        this.datosProducto = factory.getProductoDAO();
        this.datosPedido = factory.getPedidoDAO();
    }

    // Listar con búsqueda por nombre de producto
    public DefaultTableModel listar(String texto) {
        List<PedidoDetalle> lista = new ArrayList<>();
        lista.addAll(datosDetalle.listar(texto));

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
        if (datosDetalle.insertar(d)) {
            return "Registro insertado exitosamente";
        } else {
            return "Error al insertar el registro";
        }
    }

    public String actualizar(PedidoDetalle d) {
        if (datosDetalle.actualizar(d)) {
            return "Registro actualizado exitosamente";
        } else {
            return "Error al actualizar el registro";
        }
    }

    public String eliminar(PedidoDetalle d) {
        if (datosDetalle.eliminar(d)) {
            return "Registro eliminado exitosamente";
        } else {
            return "Error al eliminar el registro";
        }
    }

    // Combo de productos (usa tu seleccionar1() del DAO de Producto)
    public DefaultComboBoxModel seleccionar1() {
        DefaultComboBoxModel ETEMS = new DefaultComboBoxModel();
        List<Producto> lista = datosProducto.seleccionar1();

        for (Producto etem : lista) {
            Producto med = new Producto(
                    etem.getIdProducto(),
                    etem.getNombre()
            );
            ETEMS.addElement(med);
        }
        return ETEMS;
    }

    // Combo de pedidos (usa tu seleccionar() del DAO de Pedido)
    public DefaultComboBoxModel seleccionarpedido() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Pedido> lista = datosPedido.seleccionar();

        for (Pedido item : lista) {
            Pedido ped = new Pedido(
                    item.getIdPedido(),
                    item.getNumeroDePedido()
            );
            items.addElement(ped);
        }
        return items;
    }

    // Inserta detalle con método específico del DAO (si lo tienes)
    public boolean insertardeta(PedidoDetalle d) {
        return datosDetalle.insertardetalle(d);
    }
}
