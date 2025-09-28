/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capapresentacion;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class ventanapagodecuadro {
    private JTable tblProductos;

private void configurarTabla() {
    String[] columnas = {"Nº", "Producto", "Cantidad", "Precio Unitario", "Subtotal"};
    DefaultTableModel model = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Solo la columna Cantidad (2) editable
            return column == 2;
        }
    };
    tblProductos.setModel(model);
}

}
