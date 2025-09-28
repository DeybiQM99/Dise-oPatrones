/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capapresentacion;

import capaentidades.PedidoDetalle;
import capaentidades.Producto;
import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FrmDetalleProducto extends JDialog {

   private JTable tblProductos;
    private JButton btnSeleccionar, btnCancelar;
    private List<PedidoDetalle> detallesSeleccionados;

    public FrmDetalleProducto(Window parent, List<Producto> productosDisponibles) {
        super(parent, "Seleccionar Productos", ModalityType.APPLICATION_MODAL);
        setSize(600, 400);
        setLocationRelativeTo(parent);
        detallesSeleccionados = new ArrayList<>();

        String[] columnas = {"ID", "Producto", "Descripción", "Precio", "Cantidad"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tblProductos = new JTable(model);

        for (Producto p : productosDisponibles) {
            model.addRow(new Object[]{p.getIdProducto(), p.getNombre(), p.getDescripcion(), p.getPrecio(), 1});
        }

        JScrollPane scroll = new JScrollPane(tblProductos);

        btnSeleccionar = new JButton("Seleccionar ✔");
        btnCancelar = new JButton("Cancelar ✖");
        JPanel pnlBotones = new JPanel();
        pnlBotones.add(btnSeleccionar);
        pnlBotones.add(btnCancelar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(pnlBotones, BorderLayout.SOUTH);

        btnSeleccionar.addActionListener(e -> seleccionarProductos());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void seleccionarProductos() {
        int[] filas = tblProductos.getSelectedRows();
        for (int fila : filas) {
            int idProducto = (int) tblProductos.getValueAt(fila, 0);
            String nombreProducto = (String) tblProductos.getValueAt(fila, 1);
            double precioUnitario = (double) tblProductos.getValueAt(fila, 3);
            int cantidad = Integer.parseInt(tblProductos.getValueAt(fila, 4).toString());

            PedidoDetalle detalle = new PedidoDetalle();
            detalle.setIdProducto(idProducto);
            detalle.setNombreProducto(nombreProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.calcularSubtotal();

            detallesSeleccionados.add(detalle);
        }
        dispose();
    }

    public List<PedidoDetalle> getDetallesSeleccionados() {
        return detallesSeleccionados;
    }
}
