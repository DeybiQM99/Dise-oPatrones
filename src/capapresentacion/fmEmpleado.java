
package capapresentacion;

import capaentidades.TipoUsuario;
import capaentidades.Empleado;
import capaentidades.TipoUsuario;
import capanegocio.EmpleadoNegocio;
import javax.swing.JOptionPane;

public class fmEmpleado extends javax.swing.JInternalFrame {

    private final EmpleadoNegocio control;
    private String accion;
    private Empleado Empleado;
    private String resp;    
    private int idEmpleado;
    
    public fmEmpleado(Empleado emp) {
        initComponents();
        this.Empleado=emp;
        this.control=new EmpleadoNegocio();
        this.listar("");
        
        tabEmpleado.setEnabledAt(0,true);
        tabEmpleado.setEnabledAt(1,false);
        tabEmpleado.setSelectedIndex(0);
    }
    
      private void limpiar()
    {
        cbcombousuario.setSelectedIndex(0);
        this.txtusuario.setText("");
        this.txtnombre.setText("");
        this.txtapellido.setText("");
        this.txtcontrasena.setText("");
        
        
        this.accion="guardar";
    }
    private void listar(String texto) {
    tablaempleado.setModel(this.control.listar(texto));
    }
    
    
    private void cargarCombo() {
    cbcombousuario.setModel(control.seleccionar1());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabEmpleado = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btbbuscar = new javax.swing.JButton();
        btbnuevo = new javax.swing.JButton();
        btbeditar = new javax.swing.JButton();
        btbeliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaempleado = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btbcerrar = new javax.swing.JButton();
        btbguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcontrasena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbcombousuario = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        tabEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        tabEmpleado.setForeground(new java.awt.Color(18, 18, 18));
        tabEmpleado.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

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

        tablaempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaempleado);

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

        tabEmpleado.addTab("Listado", jPanel3);

        jPanel4.setBackground(new java.awt.Color(18, 18, 18));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nombre:");

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
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Contraseña");

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Tipo de usuario:");

        cbcombousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btbcerrar)
                                .addGap(39, 39, 39)
                                .addComponent(btbguardar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbcombousuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbcombousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbcerrar)
                    .addComponent(btbguardar)))
        );

        tabEmpleado.addTab("Mantenimiento", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tabEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(tabEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
              cargarCombo();
            tabEmpleado.setEnabledAt(0, false);
            tabEmpleado.setEnabledAt(1, true);
            tabEmpleado.setSelectedIndex(1);
            accion = "guardar";
            btbguardar.setText("Guardar");      
    }//GEN-LAST:event_btbnuevoActionPerformed

    private void btbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbbuscarActionPerformed
    this.listar(this.txtbuscar.getText());  
    }//GEN-LAST:event_btbbuscarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btbcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbcerrarActionPerformed
    tabEmpleado.setEnabledAt(0, true);
    tabEmpleado.setEnabledAt(1, false);
    tabEmpleado.setSelectedIndex(0);       
    }//GEN-LAST:event_btbcerrarActionPerformed

    private void btbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbguardarActionPerformed
             
          TipoUsuario tipousu = (TipoUsuario) cbcombousuario.getSelectedItem(); 
    if (tipousu == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una boleta");
        return;
    }
        
        Empleado pre = new Empleado(
            idEmpleado,
            tipousu.getIdTipoUsuario(),
            tipousu.getDescripcion(),
            txtusuario.getText(),
            txtnombre.getText(),
            txtapellido.getText(),
            txtcontrasena.getText()
        );

        if (accion.equals("guardar")) {
            resp = control.insertar(pre);
        } else {
            resp = control.actualizar(pre);
        }

        JOptionPane.showMessageDialog(this, resp);
        listar("");
        limpiar();
        tabEmpleado.setSelectedIndex(0);
        tabEmpleado.setEnabledAt(1, false);
        tabEmpleado.setEnabledAt(0, true);        // TODO add your handling code here:
    }//GEN-LAST:event_btbguardarActionPerformed

    private void btbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeditarActionPerformed
   if (tablaempleado.getSelectedRowCount() == 1) {
        int fila = tablaempleado.getSelectedRow();

        idEmpleado = Integer.parseInt(tablaempleado.getValueAt(fila, 0).toString());
        txtusuario.setText(tablaempleado.getValueAt(fila, 3).toString()); // Fecha
        txtnombre.setText(tablaempleado.getValueAt(fila, 4).toString()); // Hora
        txtapellido.setText(tablaempleado.getValueAt(fila,5).toString()); // Estado// Observaciones
        txtcontrasena.setText(tablaempleado.getValueAt(fila, 6).toString());

         cargarCombo();
            for (int i = 0; i < cbcombousuario.getItemCount(); i++) {
                Object obj = cbcombousuario.getItemAt(i);
                if (obj instanceof TipoUsuario) {
                    TipoUsuario cat = (TipoUsuario) obj;
                    int IdUsuarioTabla = Integer.parseInt(tablaempleado.getValueAt(fila, 1).toString());
                    if (cat.getIdTipoUsuario() == IdUsuarioTabla) {
                        cbcombousuario.setSelectedIndex(i);
                        break;
                    }
                }
            }

        // Activar pestaña para editar
        tabEmpleado.setEnabledAt(0, false);
        tabEmpleado.setEnabledAt(1, true);
        tabEmpleado.setSelectedIndex(1);
        this.accion = "editar";
        btbguardar.setText("Guardar");

    } else {
        JOptionPane.showMessageDialog(this, "Debes seleccionar una sola fila.", "Sistema", JOptionPane.WARNING_MESSAGE);
    }
        
    }//GEN-LAST:event_btbeditarActionPerformed

    private void btbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeliminarActionPerformed
      if (tablaempleado.getSelectedRowCount() == 1) {
        String idempleado = String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 0));
        
        String idTipoUsuario= String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 1));
        String descripcion=String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 2));
        String usuaria = String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 3));
        String nombre = String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 4));
        String apellido = String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 5));
        String contrasenea= String.valueOf(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 6));
     
        int idempleados = Integer.parseInt(idempleado);
        int idtipousuario = Integer.parseInt(idTipoUsuario);
            
        Empleado cat12 = new Empleado(idempleados, idtipousuario, descripcion, usuaria, nombre, apellido, contrasenea);
        String rpta = control.eliminar(cat12);
        JOptionPane.showMessageDialog(this, rpta);
        this.listar("");
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una sola fila para eliminar.");
    }     
    }//GEN-LAST:event_btbeliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbbuscar;
    private javax.swing.JButton btbcerrar;
    private javax.swing.JButton btbeditar;
    private javax.swing.JButton btbeliminar;
    private javax.swing.JButton btbguardar;
    private javax.swing.JButton btbnuevo;
    private javax.swing.JComboBox<String> cbcombousuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabEmpleado;
    private javax.swing.JTable tablaempleado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcontrasena;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
