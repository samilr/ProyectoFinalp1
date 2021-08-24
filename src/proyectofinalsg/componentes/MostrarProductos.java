/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalsg.componentes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samil Gonzalez
 */

//CLASE MOSTRARPRODUCTOS Y HEREDA DE LA CLASE JAVAX.SWING.JFRAME
public class MostrarProductos extends javax.swing.JFrame {
    
    //CONECCION A LA BASE DE DATOS
    MyDbconnect ConnexionBD = new MyDbconnect();
    Connection conectar= ConnexionBD.conexion();
    
    //CONSTRUCTOR DE LA CLASE
    public MostrarProductos() {
        initComponents();
        mostrarD();
        jPanelAdd.setVisible(false);
        jPanelFull.setVisible(true);
    }
    
    //METODOS O FUNCIONES
    public final void mostrarD() {	
  
		String[] datosJtable = {"IDproductos", "NombreProducto", "MarcaProducto", "CategoriaProducto", "PrecioProducto", "StockProducto"};
                String Colummnas [] = new String [6]; 
                
                String mySql = "select IDproductos , NombreProducto , MarcaProducto , CategoriaProducto , PrecioProducto , StockProducto from productos";
                
		DefaultTableModel model = new DefaultTableModel(null, datosJtable);

		try {
		Statement st = (Statement) conectar.createStatement();
		ResultSet result = st.executeQuery(mySql);
		
		while(result.next()){
			
			Colummnas[0]=result.getString("IDproductos");
			Colummnas[1]=result.getString("NombreProducto");
			Colummnas[2]=result.getString("MarcaProducto");
			Colummnas[3]=result.getString("CategoriaProducto");
			Colummnas[4]=result.getString("PrecioProducto");
			Colummnas[5]=result.getString("StockProducto");
			tableProductos.setModel(model);
			
			model.addRow(Colummnas);		
			}
                
                        tableProductos.setModel(model);
			}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
	}} 
    public void agregarProductos() {
            
 	String MySql = "insert into productos (NombreProducto , MarcaProducto , CategoriaProducto , PrecioProducto , StockProducto) values(?,?,?,?,?)";
      
      if((txtNombreProducto.getText().equals("")|| txtMarcaProducto.getText().equals("") ||
    		  txtCategoriaProducto.getText().equals("") || txtPrecioProducto.getText().equals("") ||
    		  txtCantidadProducto.getText().equals(""))) {
    	  JOptionPane.showMessageDialog(null,"Complete todos los campos");
    	  
      } else {
                  try {
                      PreparedStatement Pstatement=(PreparedStatement) conectar.prepareStatement(MySql);
                      
                      Pstatement.setString(1,txtNombreProducto.getText());
                      Pstatement.setString(2,txtMarcaProducto.getText());
                      Pstatement.setString(3,txtCategoriaProducto.getText());
                      Pstatement.setString(4,txtPrecioProducto.getText());
                      Pstatement.setString(5,txtCantidadProducto.getText());
           
                  Pstatement.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Producto Agregado Exitosamente!!");
      
                 mostrarD();

                 
                  } catch (SQLException e1) {
                	  JOptionPane.showMessageDialog(null,"No se ha podido agregar :( " + e1.getMessage());
                  }
              }

      }
    public void eliminarProducto() {
		int fila = tableProductos.getSelectedRow();
		
		try {
			String mySql = "delete from productos where IDproductos =" + tableProductos.getValueAt(fila, 0);
			
			Statement st = (Statement) conectar.createStatement();
			
			int c = st.executeUpdate(mySql);
			
			if(c >= 0) {
				
				JOptionPane.showMessageDialog(null, "Se elimino los datos de usuario");	
                                mostrarD();        
			} 
		}
                
                
		
		catch (HeadlessException | SQLException e){
			System.out.println("Error al eliminar los datos de usuario " + e.getMessage());	
		}
	}
    public void actualizarProductos() {	
		
		 try {
			 
		   String mySql = "update productos set NombreProducto =?, MarcaProducto =?, CategoriaProducto =?, PrecioProducto =?, StockProducto =? where IDproductos  = ?"; 
		   int fila = tableProductos.getSelectedRow();
                   String ok = (String) tableProductos.getValueAt(fila, 0);
		   	   
	       PreparedStatement Pstatement= (PreparedStatement) conectar.prepareStatement(mySql);
	       
                    Pstatement.setString(1,txtNombreProducto.getText());
                    Pstatement.setString(2,txtMarcaProducto.getText());
                    Pstatement.setString(3,txtCategoriaProducto.getText());
                    Pstatement.setString(4,txtPrecioProducto.getText());
                    Pstatement.setString(5,txtCantidadProducto.getText());
                    Pstatement.setString(6,ok);	
	       
	       Pstatement.execute();
	       JOptionPane.showMessageDialog(null,"Se ha actualizado exitosamente!!");
               
               mostrarD();
	       
	   } catch (SQLException e1) {
		   JOptionPane.showMessageDialog(null,"No se ha podido actualizar :( " + e1.getMessage());
	   }
		 
	}
   

   //METODOS CREADOS POR EL IDE AL SOLICITAR UN EVENTO A UN COMPONENTE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFull = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanelAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMarcaProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCategoriaProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFull.setBackground(new java.awt.Color(240, 11, 11));
        jPanelFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PROYECTO FINAL");
        jPanelFull.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 240, 50));

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("SAMIR GONZALEZ");
        jPanelFull.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 240, 50));

        jLabel17.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("2019-8341");
        jPanelFull.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 160, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/caja.png"))); // NOI18N
        jPanelFull.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 220, 190));

        jPanel12.setBackground(new java.awt.Color(240, 11, 11));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/flecha-hacia-atras.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        jPanelFull.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        getContentPane().add(jPanelFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 490));

        jPanelAdd.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelAddMouseClicked(evt);
            }
        });
        jPanelAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanelAdd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 170, 30));

        txtCantidadProducto.setBorder(null);
        jPanelAdd.add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 300, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel3.setText("NOMBRE");
        jPanelAdd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        txtNombreProducto.setBorder(null);
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });
        jPanelAdd.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel4.setText("MARCA");
        jPanelAdd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 30));

        txtMarcaProducto.setBorder(null);
        jPanelAdd.add(txtMarcaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 300, 30));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setText("CATEGORIA");
        jPanelAdd.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 30));

        txtCategoriaProducto.setBorder(null);
        jPanelAdd.add(txtCategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 300, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel6.setText("PRECIO");
        jPanelAdd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, 30));

        txtPrecioProducto.setBorder(null);
        jPanelAdd.add(txtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 30));
        jPanelAdd.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 300, -1));
        jPanelAdd.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 300, 10));
        jPanelAdd.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 300, 10));
        jPanelAdd.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 300, 10));
        jPanelAdd.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 300, 10));

        jPanel2.setBackground(new java.awt.Color(240, 11, 11));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE PRODUCTOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 30));

        jPanelAdd.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 60));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/plus.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanelAdd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 50, 70));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samil Gonzalez\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoFinalSg\\src\\proyectofinalsg\\componentes\\img\\editar.png")); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanelAdd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 50, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/eliminar.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanelAdd.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 50, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/flecha-hacia-atras - Copy.png"))); // NOI18N
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanelAdd.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 70, 50));

        getContentPane().add(jPanelAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 490));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(240, 11, 11));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADMINISTRADOR DE PRODUCTOS");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 430, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableProductos.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 580, 390));

        jPanel7.setBackground(new java.awt.Color(240, 11, 11));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 580, 40));

        jPanel9.setBackground(new java.awt.Color(240, 11, 11));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 60, 420));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 490));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/login.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 210, 220));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinalsg/componentes/img/Sin título-1.jpg"))); // NOI18N
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, -20, 300, 560));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SAMIR GONZALEZ");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 240, 90));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("2019-8341");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 220, 60));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PROYECTO FINAL");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 240, 50));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, -1, 480));

        jPanel10.setBackground(new java.awt.Color(240, 11, 11));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(240, 11, 11));

        jLabel19.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("X");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 60, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void jPanelAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelAddMouseClicked

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        int fila = tableProductos.rowAtPoint(evt.getPoint()); 
        jPanelFull.setVisible(false);
        jPanelAdd.setVisible(true);
        
        txtNombreProducto.setText(tableProductos.getValueAt(fila,1).toString());
	txtMarcaProducto.setText(tableProductos.getValueAt(fila,2).toString());
	txtCategoriaProducto.setText(tableProductos.getValueAt(fila,3).toString());
	txtPrecioProducto.setText(tableProductos.getValueAt(fila,4).toString());
	txtCantidadProducto.setText(tableProductos.getValueAt(fila,5).toString());
    }//GEN-LAST:event_tableProductosMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        actualizarProductos();
        mostrarD();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        agregarProductos();
        mostrarD();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
       eliminarProducto();
       mostrarD();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
       Inicio abrir = new Inicio();
       abrir.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        jPanelAdd.setVisible(false);
        jPanelFull.setVisible(true);
    }//GEN-LAST:event_jLabel23MouseClicked

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
            java.util.logging.Logger.getLogger(MostrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProductos().setVisible(true);
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelAdd;
    private javax.swing.JPanel jPanelFull;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCategoriaProducto;
    private javax.swing.JTextField txtMarcaProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
