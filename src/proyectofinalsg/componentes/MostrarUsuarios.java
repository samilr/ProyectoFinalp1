/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalsg.componentes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Samil Gonzalez
 */

//CLASE MostrarUsuarios Y HEREDA DE LA CLASE JAVAX.SWING.FRAME
public class MostrarUsuarios extends javax.swing.JFrame {
    
    //CONNECCION A LA BASE DE DATOS
    MyDbconnect ConnexionBD = new MyDbconnect();
    Connection conectar= ConnexionBD.conexion();

    //CONSTRUCTOR DE LA CLASE MOSTRARUSUARIOS
    public MostrarUsuarios() {
        initComponents();
        mostrarDatos();
    }
   
        //METODOS O FUNCIONES
        public void clean(){
        txtActualizarNombre.setText("");
	txtActualizarApellido.setText("");
	txtActualizarTelefono.setText("");
	txtActualizarCorreo.setText("");
	txtActualizarUsuario.setText("");	
        }
    	public final void mostrarDatos() {	
            
		String[] datosJtable = {"IDUser", "Nombre", "Apellido", "Telefono", "Correo", "UserName"};
                String Colummnas [] = new String [6]; 
                
                String mySql = "select IDUser, Nombre, Apellido, Telefono, Correo, UserName  from usuarios";
                
		DefaultTableModel model = new DefaultTableModel(null, datosJtable);

		try {
		Statement st = (Statement) conectar.createStatement();
		ResultSet result = st.executeQuery(mySql);
		
		while(result.next()){
			
			Colummnas[0]=result.getString("IDUser");
			Colummnas[1]=result.getString("Nombre");
			Colummnas[2]=result.getString("Apellido");
			Colummnas[3]=result.getString("Telefono");
			Colummnas[4]=result.getString("Correo");
			Colummnas[5]=result.getString("UserName");
			table.setModel(model);
			
			model.addRow(Colummnas);		
			}
                
                        table.setModel(model);
			}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
	}} 
        public void eliminar() {
		int fila = table.getSelectedRow();
		
		try {
			String mySql = "delete from usuarios where IDUser =" + table.getValueAt(fila, 0);
			
			Statement st = (Statement) conectar.createStatement();
			
			int c = st.executeUpdate(mySql);
			
			if(c >= 0) {
				
				JOptionPane.showMessageDialog(null, "Se elimino los datos de usuario");	
                                clean();
                                mostrarDatos();
                                
			} 
		}
                
                
		
		catch (HeadlessException | SQLException e){
			System.out.println("Error al eliminar los datos de usuario " + e.getMessage());	
		}
	}
        public void actualizarDatos() {	
		
		 try {
			 
		   String mySql = "update usuarios set Nombre=?, Apellido=?, Telefono=?, Correo=?, UserName=? where IDUser = ?"; 
		   int fila = table.getSelectedRow();
                   String ok = (String) table.getValueAt(fila, 0);
		   	   
	       PreparedStatement Pstatement= (PreparedStatement) conectar.prepareStatement(mySql);
	       
	       Pstatement.setString(1,txtActualizarNombre.getText());
	       Pstatement.setString(2,txtActualizarApellido.getText());
	       Pstatement.setString(3,txtActualizarTelefono.getText());
	       Pstatement.setString(4,txtActualizarCorreo.getText());
	       Pstatement.setString(5,txtActualizarUsuario.getText());
	       Pstatement.setString(6,ok);	
	       
	       Pstatement.execute();
	       JOptionPane.showMessageDialog(null,"Se ha actualizado exitosamente!!");
               
               clean();
               mostrarDatos();
	       
	   } catch (SQLException e1) {
		   JOptionPane.showMessageDialog(null,"No se ha podido actualizar :( " + e1.getMessage());
	   }
		 
	}
        public void agregarDatos() {
            
 		String MySql = "insert into usuarios (Nombre, Apellido, Telefono, Correo, UserName , Contraseña) values(?,?,?,?,?,?)";
      
      if((txtActualizarNombre.getText().equals("")|| txtActualizarApellido.getText().equals("") ||
    		  txtActualizarTelefono.getText().equals("") || txtActualizarCorreo.getText().equals("") ||
    		  txtActualizarUsuario.getText().equals("") || txtPassword.getText().equals(""))) {
    	  JOptionPane.showMessageDialog(null,"Complete todos los campos");
    	  
      } else {
    	 
            	  try {
                      PreparedStatement Pstatement=(PreparedStatement) conectar.prepareStatement(MySql);
                      
                      Pstatement.setString(1,txtActualizarNombre.getText());
                      Pstatement.setString(2,txtActualizarApellido.getText());
                      Pstatement.setString(3,txtActualizarTelefono.getText());

                      Pstatement.setString(4,txtActualizarCorreo.getText());
                      Pstatement.setString(5,txtActualizarUsuario.getText());
                      
                      Pstatement.setString(6,txtPassword.getText());
                      
                  Pstatement.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Usuario Agregado Exitosamente!!");
                  
                  clean();
                  mostrarDatos();
                  
                  } catch (SQLException e1) {
                	  JOptionPane.showMessageDialog(null,"No se ha podido agregar :( " + e1.getMessage());
                  }
              }

      }
        
	

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        
    //METODOS CREADOS POR EL IDE AL PEDIR UN EVENTO A UN COMPONENTE.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtActualizarCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtActualizarUsuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtActualizarNombre = new javax.swing.JTextField();
        txtActualizarTelefono = new javax.swing.JTextField();
        txtActualizarApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.setSelectionBackground(new java.awt.Color(240, 11, 11));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 950, 200));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel1.setText("USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 200, 40));

        txtActualizarCorreo.setBorder(null);
        txtActualizarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtActualizarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 260, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setText("TELEFONO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 200, 40));

        txtActualizarUsuario.setBorder(null);
        txtActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtActualizarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 260, 30));

        jPanel2.setBackground(new java.awt.Color(240, 11, 11));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(240, 11, 11));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/flecha-hacia-atras.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("GETOR DE USUARIOS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 270, 40));

        jPanel8.setBackground(new java.awt.Color(240, 11, 11));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("  X");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 60, 50));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 60, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        txtActualizarNombre.setBorder(null);
        txtActualizarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtActualizarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 260, 30));

        txtActualizarTelefono.setBorder(null);
        txtActualizarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtActualizarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 260, 30));

        txtActualizarApellido.setBorder(null);
        txtActualizarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtActualizarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 260, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 200, 40));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel4.setText("APELLIDO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 200, 40));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setText("CONTRASEÑA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 200, 40));

        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 260, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setText("CORREO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 200, 40));

        jPanel3.setBackground(new java.awt.Color(240, 11, 11));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("AGREGAR");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("AGREGAR");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 180, 50));

        jPanel4.setBackground(new java.awt.Color(240, 11, 11));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ACTUALIZAR");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 180, 50));

        jPanel5.setBackground(new java.awt.Color(240, 11, 11));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ELIMINAR");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 180, 50));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("AGREGAR");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 260, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 260, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 260, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 260, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 260, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 260, 10));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ACTUALIZAR");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 141, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActualizarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarCorreoActionPerformed

    private void txtActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarUsuarioActionPerformed

    private void txtActualizarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarNombreActionPerformed

    private void txtActualizarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarTelefonoActionPerformed

    private void txtActualizarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarApellidoActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Inicio abrirInicio = new Inicio();
        abrirInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
            agregarDatos();
            mostrarDatos();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        actualizarDatos();
        mostrarDatos();   
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        eliminar();
        mostrarDatos();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
  	
         int fila = table.rowAtPoint(evt.getPoint()); 
					
        txtActualizarNombre.setText(table.getValueAt(fila,1).toString());
	txtActualizarApellido.setText(table.getValueAt(fila,2).toString());
	txtActualizarTelefono.setText(table.getValueAt(fila,3).toString());
	txtActualizarCorreo.setText(table.getValueAt(fila,4).toString());
	txtActualizarUsuario.setText(table.getValueAt(fila,5).toString());				
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
            agregarDatos();
            mostrarDatos();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
            actualizarDatos();
            mostrarDatos(); 
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
            eliminar();
            mostrarDatos();
    }//GEN-LAST:event_jLabel11MouseClicked

    //METODO MAIN
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
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarUsuarios().setVisible(true);
            }
        });
    }
       //PROPIEDADES O ATRIUTOS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtActualizarApellido;
    private javax.swing.JTextField txtActualizarCorreo;
    private javax.swing.JTextField txtActualizarNombre;
    private javax.swing.JTextField txtActualizarTelefono;
    private javax.swing.JTextField txtActualizarUsuario;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
