package conexion;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
public class conexion {
	
	
	Connection conexion = null;
	
	String controlador = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/prueba";
	String usuario = "root";
	
	
	
	
	
	public conexion () {
		try {
			Class.forName(controlador);
			conexion = DriverManager.getConnection(url, usuario, "");
			System.out.println("te conectaste");
			
			String Query =("Insert into registros (Nombre, Apellido, Edad) values ('Elvis', 'Garcia', 18)");
			
			Statement stm = conexion.createStatement();
			
			stm.executeUpdate(Query);
		}
		
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
}
