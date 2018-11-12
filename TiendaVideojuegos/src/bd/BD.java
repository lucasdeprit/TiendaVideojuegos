package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class BD {
	
	private static Exception lastError = null;
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	public static Statement CrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table genero " +
					"(genero_nombre string)");
			} catch (SQLException e) {}
			try {
				statement.executeUpdate("create table videojuego " +
					"(genero_nombre string, id int , videojuego_nombre string, marca string, plataforma string, descripcion string, edad int, precio double )");
			} catch (SQLException e) {
				
			}
			return statement;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists genero");
			statement.executeUpdate("drop table if exists videojuegos");
			return CrearTablasBD( con );
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
		}
	}
	
	
	
}
