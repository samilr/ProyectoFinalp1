/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalsg.componentes;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Samil Gonzalez
 */
    
    //USER "estuditla8341" ESTE USER ES DEBIDO A QUE EL USER ESTUDIANTEITLA YA ESSTABA EN USO.
    //PASSWORD "itla123."
public class MyDbconnect {
    
	Connection conectar = null;
	public Connection conexion() {

	   try {
		conectar = (Connection) DriverManager.getConnection("jdbc:mysql://db4free.net:3306/almacenitla8341?characterEncoding=utf8&useSSL=false&useUnicode=true", "estuditla8341", "itla123.");//Establishing connection
		System.out.println("Se establecio la conexion a la base de datos");
		
	} catch (SQLException e) {
		
		System.out.println("Error al conectara a la base de datos " + e.getMessage());
	
		}
	return conectar;
}		
}
