/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//NOMBRE DEL PAQUETE
package proyectofinalsg.componentes;

//IMPORTACIONES DE LIBRERIAS
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Samil Gonzalez
 */

//CLASE LOGIN Y HEREDA DE LA CLASE JAVA.SWING.FRAME
public class Login extends javax.swing.JFrame {
        //CONECCION A LA BASE DE DATOS
    	MyDbconnect ConnexionBD = new MyDbconnect();
	Connection conectar= ConnexionBD.conexion();

   //CONSTRUCTOR
    public Login() {
        initComponents();
    }
    
    //METODO INICIAR SECCION
    public void IniciarSeccion() {

		String MySql = "Select UserName, CONTRASEÑA from usuarios where UserName=? and CONTRASEÑA=?";
		String Usuario = txtUsuario.getText();
                String Contraseña = txtContraseña.getText();
        try {
            PreparedStatement st = (PreparedStatement) conectar.prepareStatement(MySql);

            st.setString(1, Usuario);
            st.setString(2, Contraseña);
            ResultSet rs = st.executeQuery();
            
            if((Usuario.equals("")|| Contraseña.equals("") )){
            	
            	JOptionPane.showMessageDialog(null, "Complete todos los campos");
            	
            }else {
             
            if(rs.next()) {
         
            	JOptionPane.showMessageDialog(null, "Inicio de seccion Exitoso");
            	
           	this.dispose();      	
           	Inicio abrirInicio = new Inicio();
           	abrirInicio.setVisible(true);
   
           	
            } else {
           	 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
           	 txtUsuario.setText("");
           	 txtContraseña.setText("");
            	}
            }
            
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null,"Error al iniciar seccion :( " + e.getMessage());
        }
    }

    //METODOS GENERADOS POR EL IDE AL SOLICITAR UN EVENTO A UN COMPONENTE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JPasswordField();
        jPanelEntrar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelExit = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanelRegistrarse = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/login.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 210, 220));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PROYECTO FINAL");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 240, 50));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("2019-8341");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 220, 60));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SAMIR GONZALEZ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 240, 90));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/Sin título-1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, -10, 300, 560));

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setBorder(null);
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 440, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setText("INICIAR SECCIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 440, 60));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setText("USUARIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 260, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 390, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setText("CONTRASEÑA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 260, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 390, -1));

        txtContraseña.setBorder(null);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 390, 30));

        jPanelEntrar.setBackground(new java.awt.Color(248, 11, 11));
        jPanelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelEntrarMouseExited(evt);
            }
        });
        jPanelEntrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("    ENTRAR");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
        });
        jPanelEntrar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 20));

        jPanel1.add(jPanelEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 160, 40));

        jPanelExit.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelExitMouseExited(evt);
            }
        });

        jLabelExit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelExit.setText("  X");
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelExitLayout = new javax.swing.GroupLayout(jPanelExit);
        jPanelExit.setLayout(jPanelExitLayout);
        jPanelExitLayout.setHorizontalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExitLayout.createSequentialGroup()
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 767, Short.MAX_VALUE))
        );
        jPanelExitLayout.setVerticalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExitLayout.createSequentialGroup()
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        jPanelRegistrarse.setBackground(new java.awt.Color(248, 11, 11));
        jPanelRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelRegistrarseMouseExited(evt);
            }
        });
        jPanelRegistrarse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REGISTRARSE");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanelRegistrarse.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 115, 40));

        jPanel1.add(jPanelRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void jPanelRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRegistrarseMouseEntered
        jPanelRegistrarse.setBackground(new Color(252,103,103));
    }//GEN-LAST:event_jPanelRegistrarseMouseEntered

    
    private void jPanelRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRegistrarseMouseExited
        jPanelRegistrarse.setBackground(new Color(248,11,11));       
    }//GEN-LAST:event_jPanelRegistrarseMouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jPanelEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEntrarMouseExited
        jPanelEntrar.setBackground(new Color(248,11,11));    
    }//GEN-LAST:event_jPanelEntrarMouseExited

    private void jPanelEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEntrarMouseEntered
       jPanelEntrar.setBackground(new Color(252,103,103));
    }//GEN-LAST:event_jPanelEntrarMouseEntered

    private void jPanelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitMouseEntered
      
    }//GEN-LAST:event_jPanelExitMouseEntered

    private void jPanelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitMouseExited

    }//GEN-LAST:event_jPanelExitMouseExited

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited

    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered

    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jPanelRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRegistrarseMouseClicked
        Inicio Abrir = new Inicio();
        
    }//GEN-LAST:event_jPanelRegistrarseMouseClicked

    private void jPanelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEntrarMouseClicked
        IniciarSeccion();
    }//GEN-LAST:event_jPanelEntrarMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Registrar abrirRegistrar = new Registrar ();
        abrirRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    //METODO MAIN (PRINCIPAL)
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    //ATRIBUTOS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEntrar;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelRegistrarse;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
