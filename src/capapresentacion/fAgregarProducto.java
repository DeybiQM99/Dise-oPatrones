/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capapresentacion;

import capaentidades.Producto;
import capanegocio.ProductoNegocio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class fAgregarProducto extends JDialog {
    private JTable tblProductos;
    private DefaultTableModel modelo;
    private femitirpago ventanaPrincipal;

    public fAgregarProducto(femitirpago parent) {
        super((JFrame) null, "Seleccionar Producto", true);
        this.ventanaPrincipal = parent;
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Columnas de la tabla
        String[] columnas = {"IdProducto", "Nombre", "Precio"};
        modelo = new DefaultTableModel(columnas, 0);
        tblProductos = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tblProductos);
        scroll.setBounds(20, 20, 550, 250);
        add(scroll);

        // Botón seleccionar
        JButton btnSeleccionar = new JButton("Agregar");
        btnSeleccionar.setBounds(220, 300, 120, 30);
        add(btnSeleccionar);

        cargarProductos();

        // Evento al hacer clic en Agregar
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarProducto();
            }
        });
    }

    private void cargarProductos() {
        ProductoNegocio negocio = new ProductoNegocio();
        List<Producto> lista = negocio.listar1();  // 👈 asegúrate que ya tienes este método
        for (Producto p : lista) {
            Object[] fila = {
                p.getIdProducto(),
                p.getNombre(),
                p.getPrecio()
            };
            modelo.addRow(fila);
        }
    }
    private void seleccionarProducto() {
        int fila = tblProductos.getSelectedRow();
        if (fila >= 0) {
            int idProducto = (int) modelo.getValueAt(fila, 0);
            String nombre = modelo.getValueAt(fila, 1).toString();
            double precio = Double.parseDouble(modelo.getValueAt(fila, 2).toString());
            String input = JOptionPane.showInputDialog(this, "Cantidad:", "1");
            int cantidad = Integer.parseInt(input);
            double subtotal = cantidad * precio;
            ventanaPrincipal.agregarDetalleProducto(idProducto, nombre, cantidad, precio, subtotal);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto primero");
        }
    }
}