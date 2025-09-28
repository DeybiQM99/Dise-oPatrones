
package capapresentacion;

import capaentidades.Categoria;
import capaentidades.Empleado;
import capaentidades.TipoUsuario;
import capanegocio.CategoriaNegocio;
import capanegocio.TipoUsuarioNegocio;
import javax.swing.JOptionPane;

public class fmCategoria extends javax.swing.JInternalFrame {

    private final CategoriaNegocio control;
    private String accion;
    private Categoria Categoria;
    private String resp;    
    private int idcategoria;
    private Empleado Empleado;
    public fmCategoria(Empleado emp) {
        initComponents();
        this.Empleado=emp;
        this.control=new CategoriaNegocio();
        this.listar("");
        tabusuario.setEnabledAt(0,true);
        tabusuario.setEnabledAt(1,false);
        tabusuario.setSelectedIndex(0);
    }
      private void limpiar()
    {
        this.txtcategoria.setText("");
        this.accion="guardar";

    }
    private void listar(String texto) {
        tablacategoria.setModel(this.control.listar(texto));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabusuario = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JTextField();
        btbcerrar = new javax.swing.JButton();
        btbguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btbbuscar = new javax.swing.JButton();
        btbnuevo = new javax.swing.JButton();
        btbeditar = new javax.swing.JButton();
        btbeliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacategoria = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        tabusuario.setBackground(new java.awt.Color(255, 255, 255));
        tabusuario.setForeground(new java.awt.Color(18, 18, 18));
        tabusuario.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(18, 18, 18));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Ingrese la categoria");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btbcerrar)
                        .addGap(38, 38, 38)
                        .addComponent(btbguardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbcerrar)
                    .addComponent(btbguardar)))
        );

        tabusuario.addTab("Mantenimiento", jPanel4);

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

        tablacategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablacategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablacategoria.setUpdateSelectionOnSort(false);
        tablacategoria.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(tablacategoria);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btbbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btbnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btbeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbeliminar)))
                .addGap(0, 54, Short.MAX_VALUE))
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
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        tabusuario.addTab("Listado", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tabusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(tabusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btbcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbcerrarActionPerformed
    tabusuario.setEnabledAt(0, true);
    tabusuario.setEnabledAt(1, false);
    tabusuario.setSelectedIndex(0);       
    }//GEN-LAST:event_btbcerrarActionPerformed

    private void btbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbguardarActionPerformed
     Categoria prod = new Categoria(
            idcategoria,
            txtcategoria.getText()
        );

        if (accion.equals("guardar")) {
            resp = control.insertar(prod);
        } else {
            resp = control.actualizar(prod);
        }

        JOptionPane.showMessageDialog(this, resp);
        listar("");
        limpiar();
        tabusuario.setSelectedIndex(0);
        tabusuario.setEnabledAt(1, false);
        tabusuario.setEnabledAt(0, true);        // TODO add your handling code here:
    }//GEN-LAST:event_btbguardarActionPerformed

    private void btbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeliminarActionPerformed
        if (tablacategoria.getSelectedRowCount() == 1) {
            String idcategori = String.valueOf(tablacategoria.getValueAt(tablacategoria.getSelectedRow(), 0));
            String Nombre = String.valueOf(tablacategoria.getValueAt(tablacategoria.getSelectedRow(), 1));

            int idcategoria = Integer.parseInt(idcategori);

            Categoria cat = new Categoria(idcategoria, Nombre);
            String rpta = control.eliminar(cat);
            JOptionPane.showMessageDialog(this, rpta);
            this.listar("");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una sola fila para eliminar.");
        }
    }//GEN-LAST:event_btbeliminarActionPerformed

    private void btbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbeditarActionPerformed
        if (tablacategoria.getSelectedRowCount() == 1) {
            String idcategoria = String.valueOf(tablacategoria.getValueAt(tablacategoria.getSelectedRow(), 0));
            String Nombre = String.valueOf(tablacategoria.getValueAt(tablacategoria.getSelectedRow(), 1));

            this.idcategoria =Integer.parseInt(idcategoria);
            this.txtcategoria.setText(Nombre);

            tabusuario.setEnabledAt(0,false);
            tabusuario.setEnabledAt(1,true);
            tabusuario.setSelectedIndex(1);
            this.accion="editar";
            btbguardar.setText("Guardar");

        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una sola fila.", "Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btbeditarActionPerformed

    private void btbnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbnuevoActionPerformed
        limpiar();
        tabusuario.setEnabledAt(0, false);
        tabusuario.setEnabledAt(1, true);
        tabusuario.setSelectedIndex(1);
        accion = "guardar";
        btbguardar.setText("Guardar");
    }//GEN-LAST:event_btbnuevoActionPerformed

    private void btbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbbuscarActionPerformed
        this.listar(this.txtbuscar.getText());
    }//GEN-LAST:event_btbbuscarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbbuscar;
    private javax.swing.JButton btbcerrar;
    private javax.swing.JButton btbeditar;
    private javax.swing.JButton btbeliminar;
    private javax.swing.JButton btbguardar;
    private javax.swing.JButton btbnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablacategoria;
    private javax.swing.JTabbedPane tabusuario;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcategoria;
    // End of variables declaration//GEN-END:variables
}
