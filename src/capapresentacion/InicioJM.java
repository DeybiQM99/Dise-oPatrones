/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package capapresentacion;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author carlo
 */
public class InicioJM extends javax.swing.JFrame {

    public static JDesktopPane escritorio = new JDesktopPane(); 

    public InicioJM() {
          setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(escritorio);
        initComponents();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btbusuarios = new javax.swing.JLabel();
        btbusuarios1 = new javax.swing.JLabel();
        btbusuarios2 = new javax.swing.JLabel();
        btbusuarios3 = new javax.swing.JLabel();
        btbusuarios4 = new javax.swing.JLabel();
        btbusuarios5 = new javax.swing.JLabel();
        btbcliente = new javax.swing.JLabel();
        btbtpago = new javax.swing.JLabel();
        btbtpago1 = new javax.swing.JLabel();
        btbusuarios6 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 33, 36));

        jPanel2.setBackground(new java.awt.Color(51, 48, 51));

        btbusuarios.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios.setText("Usuarios");
        btbusuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuariosMouseClicked(evt);
            }
        });

        btbusuarios1.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios1.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios1.setText("Empleado");
        btbusuarios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios1MouseClicked(evt);
            }
        });

        btbusuarios2.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios2.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios2.setText("Producto");
        btbusuarios2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios2MouseClicked(evt);
            }
        });

        btbusuarios3.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios3.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios3.setText("categoria");
        btbusuarios3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios3MouseClicked(evt);
            }
        });

        btbusuarios4.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios4.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios4.setText("Detalle Pedido");
        btbusuarios4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios4MouseClicked(evt);
            }
        });

        btbusuarios5.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbusuarios5.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbusuarios5.setText("pedido");
        btbusuarios5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios5MouseClicked(evt);
            }
        });

        btbcliente.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbcliente.setForeground(new java.awt.Color(242, 242, 242));
        btbcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbcliente.setText("Cliente");
        btbcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbclienteMouseClicked(evt);
            }
        });

        btbtpago.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbtpago.setForeground(new java.awt.Color(242, 242, 242));
        btbtpago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_10613751 (1).png"))); // NOI18N
        btbtpago.setText("Pago");
        btbtpago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbtpagoMouseClicked(evt);
            }
        });

        btbtpago1.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        btbtpago1.setForeground(new java.awt.Color(242, 242, 242));
        btbtpago1.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlo\\Documents\\NetBeansProjects\\Proyectodeburgermax\\src\\img\\user_10613751 (1).png")); // NOI18N
        btbtpago1.setText("Comprobante");
        btbtpago1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbtpago1MouseClicked(evt);
            }
        });

        btbusuarios6.setFont(new java.awt.Font("Open Sans Semibold", 0, 24)); // NOI18N
        btbusuarios6.setForeground(new java.awt.Color(242, 242, 242));
        btbusuarios6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/burger_2011054.png"))); // NOI18N
        btbusuarios6.setText("Hamburguesa ");
        btbusuarios6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbusuarios6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btbusuarios6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btbtpago1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btbusuarios6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(btbtpago1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btbtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbusuarios5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbusuarios4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbusuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbusuarios3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btbusuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 774, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setJMenuBar(menuBar);

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

    private void btbusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuariosMouseClicked
    
        fLoginAdministrador2 frm = new fLoginAdministrador2();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true);            
    }//GEN-LAST:event_btbusuariosMouseClicked

    private void btbusuarios1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios1MouseClicked
    
        fLoginAdministrador1 frm = new fLoginAdministrador1();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true);      
    }//GEN-LAST:event_btbusuarios1MouseClicked

    private void btbusuarios2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios2MouseClicked
        fLoginCocinero2 frm = new fLoginCocinero2();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
    }//GEN-LAST:event_btbusuarios2MouseClicked

    private void btbusuarios3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios3MouseClicked
     
        fLoginAdministrador frm = new fLoginAdministrador();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true);        
    }//GEN-LAST:event_btbusuarios3MouseClicked

    private void btbusuarios4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios4MouseClicked
         fLoginCocinero1 frm = new fLoginCocinero1();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
    }//GEN-LAST:event_btbusuarios4MouseClicked

    private void btbusuarios5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios5MouseClicked
         fLoginCocinero frm = new fLoginCocinero();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
    }//GEN-LAST:event_btbusuarios5MouseClicked

    private void btbclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbclienteMouseClicked
           fLoginCajera2 frm = new fLoginCajera2();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
    }//GEN-LAST:event_btbclienteMouseClicked

    private void btbtpagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbtpagoMouseClicked
   
         fLoginCajera1 frm = new fLoginCajera1();  // Crear instancia
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
        
    }//GEN-LAST:event_btbtpagoMouseClicked

    private void btbtpago1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbtpago1MouseClicked
     fLoginCajera frm = new fLoginCajera();  
    InicioJM.escritorio.add(frm);   // Agregar al JDesktopPane del principal
    frm.setVisible(true); 
    }//GEN-LAST:event_btbtpago1MouseClicked

    private void btbusuarios6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbusuarios6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btbusuarios6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioJM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btbcliente;
    private javax.swing.JLabel btbtpago;
    private javax.swing.JLabel btbtpago1;
    private javax.swing.JLabel btbusuarios;
    private javax.swing.JLabel btbusuarios1;
    private javax.swing.JLabel btbusuarios2;
    private javax.swing.JLabel btbusuarios3;
    private javax.swing.JLabel btbusuarios4;
    private javax.swing.JLabel btbusuarios5;
    private javax.swing.JLabel btbusuarios6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
