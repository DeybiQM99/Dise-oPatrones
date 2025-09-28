
package capapresentacion;

import capaentidades.Empleado;
import capaentidades.Pedido;
import capaentidades.PedidoDetalle;
import capaentidades.TipoUsuario;
import capanegocio.DetallepedidoNegocio;
import capanegocio.PedidoNegocio;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.beans.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.List;
import conexion.conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

public class fmpedido extends javax.swing.JInternalFrame {
    private final PedidoNegocio control;
    private String accion;
    private Pedido Pedido;
    private String resp;    
    private int idpedido;
       private final conexion cnx;
       private Pedido pedido;
private Empleado  Empleado;

       
       
    
    public fmpedido(Empleado emp) {
        initComponents();
        this.control=new PedidoNegocio();
        this.Empleado=emp;
        this.listar("");
        tabpedido.setEnabledAt(0,true);
        tabpedido.setEnabledAt(1,false);
        tabpedido.setSelectedIndex(0);
        dateFecha.setDate(new Date());  // JDateChooser
        spinnerHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(timeEditor);
        spinnerHora.setValue(new Date()); 
         this.cnx = conexion.getInstancia();
            
    }
    
       
    private static int contadorPedido = 1;   // empieza en 1

private String generarNumeroPedido() {
    String numero = "PED-" + contadorPedido;  
    contadorPedido++;
    return numero;
}
    

    
    
  private void limpiar() {
    txtnumerodepedido.setText("");
    cbestado.setSelectedIndex(0);
    dateFecha.setDate(new Date());
    spinnerHora.setValue(new Date());
    accion = "guardar";
    }
      
     
      
    private void listar(String texto) {
    tablapedido.setModel(this.control.listar(texto));
    }
    
    
    private String generarNumeroPedidoDesdeBD() {
    String numero = "PED-10000000"; // valor por defecto
    String sql = "SELECT COALESCE(MAX(idpedido), 0) AS ultimo FROM pedido";

    try (Connection conn = cnx.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            int ultimo = rs.getInt("ultimo");  // si no hay filas devuelve 0
            numero = "PED-" + (ultimo + 1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return numero;
    
}
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabpedido = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btbbuscar = new javax.swing.JButton();
        btbnuevo = new javax.swing.JButton();
        btbeditar = new javax.swing.JButton();
        btbeliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapedido = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btbcerrar = new javax.swing.JButton();
        btbguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnumerodepedido = new javax.swing.JTextField();
        spinnerHora = new javax.swing.JSpinner();
        dateFecha = new com.toedter.calendar.JDateChooser();
        cbestado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        tabpedido.setBackground(new java.awt.Color(255, 255, 255));
        tabpedido.setForeground(new java.awt.Color(18, 18, 18));
        tabpedido.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(18, 18, 18));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("busqueda");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btbbuscar.setText("Buscar");
        btbbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbbuscarActionPerformed(evt);
            }
        });

        btbnuevo.setText("Nuevo");
        btbnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbnuevoActionPerformed(evt);
            }
        });

        btbeditar.setText("Editar");
        btbeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbeditarActionPerformed(evt);
            }
        });

        btbeliminar.setText("Eliminar");
        btbeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbeliminarActionPerformed(evt);
            }
        });

        tablapedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablapedido);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbeditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btbeliminar))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbbuscar)
                    .addComponent(btbnuevo)
                    .addComponent(btbeditar)
                    .addComponent(btbeliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tabpedido.addTab("Listado", jPanel3);

        jPanel4.setBackground(new java.awt.Color(18, 18, 18));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Hora:");

        btbcerrar.setText("Cerrar");
        btbcerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbcerrarActionPerformed(evt);
            }
        });

        btbguardar.setText("Guardar");
        btbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbguardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Numero de pedido:");

        fecha.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(242, 242, 242));
        fecha.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("estado:");

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "En Preparacion", "Completado" }));
        cbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbestadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumerodepedido, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerHora, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbestado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btbcerrar)
                                .addGap(39, 39, 39)
                                .addComponent(btbguardar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnumerodepedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha)
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbcerrar)
                    .addComponent(btbguardar)))
        );

        tabpedido.addTab("Mantenimiento", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tabpedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(tabpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbnuevoActionPerformed
            limpiar();
            txtnumerodepedido.setText(generarNumeroPedidoDesdeBD());
            tabpedido.setEnabledAt(0, false);
            tabpedido.setEnabledAt(1, true);
            tabpedido.setSelectedIndex(1);
            accion = "guardar";
            btbguardar.setText("Guardar");      
    }//GEN-LAST:event_btbnuevoActionPerformed

    private void btbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbbuscarActionPerformed
    this.listar(this.txtbuscar.getText());  
    }//GEN-LAST:event_btbbuscarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btbcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbcerrarActionPerformed
    tabpedido.setEnabledAt(0, true);
    tabpedido.setEnabledAt(1, false);
    tabpedido.setSelectedIndex(0);       
    }//GEN-LAST:event_btbcerrarActionPerformed

    private void btbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbguardarActionPerformed
  if (txtnumerodepedido.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Debe ingresar el número de pedido");
    return;
}

String numeroPedido = txtnumerodepedido.getText().trim();
java.util.Date horaDate = (java.util.Date) spinnerHora.getValue();
java.sql.Time horaSQL = new java.sql.Time(horaDate.getTime());
java.util.Date fechaDate = dateFecha.getDate();
String fecha = new java.sql.Date(fechaDate.getTime()).toString();

String estado = cbestado.getSelectedItem().toString();

// Creamos el pedido con hora como Time
Pedido pre = new Pedido(idpedido, numeroPedido, horaSQL, fechaDate, estado);

if (accion.equals("guardar")) {
    resp = control.insertar(pre);
} else {
    resp = control.actualizar(pre);
}

JOptionPane.showMessageDialog(this, resp);
listar("");

// Volvemos a la pestaña de listado
tabpedido.setEnabledAt(0, true);
tabpedido.setEnabledAt(1, false);
tabpedido.setSelectedIndex(0);
    }//GEN-LAST:event_btbguardarActionPerformed

    private void btbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeditarActionPerformed
  if (tablapedido.getSelectedRowCount() == 1) {
    int fila = tablapedido.getSelectedRow();

    idpedido = Integer.parseInt(tablapedido.getValueAt(fila, 0).toString());
    txtnumerodepedido.setText(tablapedido.getValueAt(fila, 1).toString());

    // --- Hora ---
    try {
        String horaStr = tablapedido.getValueAt(fila, 2).toString();  // "HH:mm:ss"
        java.text.SimpleDateFormat sdfHora = new java.text.SimpleDateFormat("HH:mm:ss");
        java.util.Date horaDate = sdfHora.parse(horaStr);
        spinnerHora.setValue(horaDate);  // ponerlo en el JSpinner
    } catch (Exception e) {
        e.printStackTrace();
    }

    // --- Fecha ---
    try {
        String fechaStr = tablapedido.getValueAt(fila, 3).toString(); // "yyyy-MM-dd"
        java.text.SimpleDateFormat sdfFecha = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaDate = sdfFecha.parse(fechaStr);
        dateFecha.setDate(fechaDate);   // ponerlo en el JDateChooser
    } catch (Exception e) {
        e.printStackTrace();
    }

    // --- Estado ---
    cbestado.setSelectedItem(tablapedido.getValueAt(fila, 4).toString());

    // Activar pestaña edición
    tabpedido.setEnabledAt(0, false);
    tabpedido.setEnabledAt(1, true);
    tabpedido.setSelectedIndex(1);

    this.accion = "editar";
    btbguardar.setText("Actualizar");
} else {
    JOptionPane.showMessageDialog(this, "Debes seleccionar una sola fila.");
}
        
    }//GEN-LAST:event_btbeditarActionPerformed

    private void btbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeliminarActionPerformed
     if (tablapedido.getSelectedRowCount() == 1) {
    String idpedido = String.valueOf(tablapedido.getValueAt(tablapedido.getSelectedRow(), 0));
    String numero = String.valueOf(tablapedido.getValueAt(tablapedido.getSelectedRow(), 1));
    String hora = String.valueOf(tablapedido.getValueAt(tablapedido.getSelectedRow(), 2));
    String fecha = String.valueOf(tablapedido.getValueAt(tablapedido.getSelectedRow(), 3));
    String estado = String.valueOf(tablapedido.getValueAt(tablapedido.getSelectedRow(), 4));

    int idpedidos = Integer.parseInt(idpedido);

    Pedido pedido = new Pedido(idpedidos, numero);
    String rpta = control.eliminar(pedido);
    JOptionPane.showMessageDialog(this, rpta);
    this.listar("");
    } else {
    JOptionPane.showMessageDialog(this, "Seleccione una sola fila para eliminar.");
    }
    }//GEN-LAST:event_btbeliminarActionPerformed

    private void cbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbestadoActionPerformed

    }//GEN-LAST:event_cbestadoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbbuscar;
    private javax.swing.JButton btbcerrar;
    private javax.swing.JButton btbeditar;
    private javax.swing.JButton btbeliminar;
    private javax.swing.JButton btbguardar;
    private javax.swing.JButton btbnuevo;
    private javax.swing.JComboBox<String> cbestado;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JTable tablapedido;
    private javax.swing.JTabbedPane tabpedido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtnumerodepedido;
    // End of variables declaration//GEN-END:variables
}
