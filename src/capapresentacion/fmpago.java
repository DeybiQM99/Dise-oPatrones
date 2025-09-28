
package capapresentacion;

import capaentidades.Empleado;
import capaentidades.Pago;
import capaentidades.Pedido;
import capaentidades.PedidoDetalle;
import capaentidades.TipoUsuario;
import capanegocio.DetallepedidoNegocio;
import capanegocio.PagoNegocio;
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

public class fmpago extends javax.swing.JInternalFrame {
    private final PagoNegocio control;
    private String accion;
    private Pedido Pedido;
    private String resp;    
    private int idpago;
   private final conexion cnx;
private Empleado  Empleado;

       
       
    
    public fmpago(Empleado emp) {
        initComponents();
        this.control=new PagoNegocio();
        this.Empleado=emp;
        this.listar("");
        tabpago.setEnabledAt(0,true);
        tabpago.setEnabledAt(1,false);
        tabpago.setSelectedIndex(0);
        dateFecha.setDate(new Date());  // JDateChooser
        spinnerHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(timeEditor);
        spinnerHora.setValue(new Date()); 
        this.cnx = conexion.getInstancia();
            
    }
    

    
    
  private void limpiar() {
    txtmonto.setText("");
    cbpago.setSelectedIndex(0);
    dateFecha.setDate(new Date());
    spinnerHora.setValue(new Date());
    accion = "guardar";
    }
      
     
      
    private void listar(String texto) {
    tablaPago.setModel(this.control.listar(texto));
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabpago = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btbbuscar = new javax.swing.JButton();
        btbnuevo = new javax.swing.JButton();
        btbeditar = new javax.swing.JButton();
        btbeliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPago = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btbcerrar = new javax.swing.JButton();
        btbguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        spinnerHora = new javax.swing.JSpinner();
        dateFecha = new com.toedter.calendar.JDateChooser();
        cbpago = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        tabpago.setBackground(new java.awt.Color(255, 255, 255));
        tabpago.setForeground(new java.awt.Color(18, 18, 18));
        tabpago.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

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

        tablaPago.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPago);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpago.addTab("Listado", jPanel3);

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
        jLabel3.setText("Metodo de pago:");

        fecha.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(242, 242, 242));
        fecha.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));

        cbpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "BCP", "YAPE", "INTERBANK" }));
        cbpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpagoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("monto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmonto))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btbcerrar)
                                .addGap(39, 39, 39)
                                .addComponent(btbguardar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpago, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbcerrar)
                    .addComponent(btbguardar)))
        );

        tabpago.addTab("Mantenimiento", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tabpago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(tabpago, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            tabpago.setEnabledAt(0, false);
            tabpago.setEnabledAt(1, true);
            tabpago.setSelectedIndex(1);
            accion = "guardar";
            btbguardar.setText("Guardar");      
    }//GEN-LAST:event_btbnuevoActionPerformed

    private void btbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbbuscarActionPerformed
    this.listar(this.txtbuscar.getText());  
    }//GEN-LAST:event_btbbuscarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btbcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbcerrarActionPerformed
    tabpago.setEnabledAt(0, true);
    tabpago.setEnabledAt(1, false);
    tabpago.setSelectedIndex(0);       
    }//GEN-LAST:event_btbcerrarActionPerformed

    private void btbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbguardarActionPerformed
     if (txtmonto.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar el monto");
        return;
    }

    // Obtener valores del formulario
    String metodo = cbpago.getSelectedItem().toString(); // 👈 ahora viene del combo
    double monto = Double.parseDouble(txtmonto.getText().trim());

    java.util.Date fechaDate = dateFecha.getDate();
    java.sql.Date fechaSQL = new java.sql.Date(fechaDate.getTime());

    java.util.Date horaDate = (java.util.Date) spinnerHora.getValue();
    java.sql.Time horaSQL = new java.sql.Time(horaDate.getTime());

    // Crear objeto Pago
    Pago pago = new Pago(idpago, metodo, monto, fechaSQL, horaSQL);

    // Guardar o actualizar según acción
    String resp;
    if (accion.equals("guardar")) {
        resp = control.insertar(pago);
    } else {
        resp = control.actualizar(pago);
    }

    // Mostrar mensaje
    JOptionPane.showMessageDialog(this, resp);

    // Refrescar tabla
    listar("");

    // Volver a la pestaña de listado
    tabpago.setEnabledAt(0, true);
    tabpago.setEnabledAt(1, false);
    tabpago.setSelectedIndex(0);
    }//GEN-LAST:event_btbguardarActionPerformed

    private void btbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeditarActionPerformed
    if (tablaPago.getSelectedRowCount() == 1) {
        // Obtener valores de la fila seleccionada
        String id = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 0));
        String metodo = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 1));
        String monto = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 2));
        String fecha = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 3));
        String hora = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 4));

        // Guardar idPago en variable global
        this.idpago = Integer.parseInt(id);

        // Cargar datos en el formulario
        cbpago.setSelectedItem(metodo);
        txtmonto.setText(monto);
        dateFecha.setDate(java.sql.Date.valueOf(fecha)); // convertir String → java.sql.Date
        spinnerHora.setValue(java.sql.Time.valueOf(hora)); // convertir String → java.sql.Time

        // Cambiar pestaña a formulario de edición
        tabpago.setEnabledAt(0, false);
        tabpago.setEnabledAt(1, true);
        tabpago.setSelectedIndex(1);

        // Cambiar acción a editar
        this.accion = "editar";
        btbguardar.setText("Guardar");

    } else {
        JOptionPane.showMessageDialog(this, "Debes seleccionar una sola fila.", "Sistema", JOptionPane.WARNING_MESSAGE);
    }
        
    }//GEN-LAST:event_btbeditarActionPerformed

    private void btbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeliminarActionPerformed
      if (tablaPago.getSelectedRowCount() == 1) {
        // Obtener el id de la fila seleccionada
        String id = String.valueOf(tablaPago.getValueAt(tablaPago.getSelectedRow(), 0));
        int idPago = Integer.parseInt(id);

        // Crear objeto Pago solo con el id
        Pago pago = new Pago();
        pago.setIdPago(idPago);

        // Eliminar usando negocio
        String rpta = control.eliminar(pago);

        // Mostrar mensaje
        JOptionPane.showMessageDialog(this, rpta);

        // Refrescar la tabla
        this.listar("");

    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una sola fila para eliminar.");
    }
    }//GEN-LAST:event_btbeliminarActionPerformed

    private void cbpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpagoActionPerformed

    }//GEN-LAST:event_cbpagoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbbuscar;
    private javax.swing.JButton btbcerrar;
    private javax.swing.JButton btbeditar;
    private javax.swing.JButton btbeliminar;
    private javax.swing.JButton btbguardar;
    private javax.swing.JButton btbnuevo;
    private javax.swing.JComboBox<String> cbpago;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JTable tablaPago;
    private javax.swing.JTabbedPane tabpago;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
