package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Viideojuego;

public class BD {

	private static Exception lastError = null;

	public static Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	public static Statement usarBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	public static Statement CrearTablasBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			try {
				statement.executeUpdate("create table genero " + "(genero_nombre string)");
			} catch (SQLException e) {
			}
			try {
				statement.executeUpdate("create table videojuego "
						+ "(id integer, nombre string,genero_nombre string, precio double )");
			} catch (SQLException e) {

			}
			return statement;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	public static Statement reiniciarBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			statement.executeUpdate("drop table if exists genero");
			statement.executeUpdate("drop table if exists videojuegos");
			return CrearTablasBD(con);
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
		}
	}

	public static Exception getLastError() { // último error producido por gestión de base de datos
		return lastError;
	}

	// Operaciones GENERO

	public static boolean generoInsert(Statement st, String genero) {
		String sentSQL = "";
		try {
			sentSQL = "insert into genero values(" + "'" + securizar(genero) + "')";
			int val = st.executeUpdate(sentSQL);
			if (val != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String> generoSelect(Statement st, String codigoSelect) {
		String sentSQL = "";
		ArrayList<String> ret = new ArrayList<>();
		try {
			sentSQL = "select * from genero";
			if (codigoSelect != null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			ResultSet rs = st.executeQuery(sentSQL);
			while (rs.next()) {
				ret.add(rs.getString("nombre"));
			}
			rs.close();
			return ret;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

//	Operaciones VIDEOJUEGO

	public static boolean videojuegoInsert(Statement st, String genero_nombre, int id,
			String nombre,double precio) {
		String sentSQL = "";
		try {
			sentSQL = "insert into reserva values('"
					+ securizar(genero_nombre) + "'," + id + "," + securizar(nombre) + "',"
					+ "',"+ precio + "',";
			int val = st.executeUpdate(sentSQL);
			if (val != 1) { // Se tiene que añadir 1 - error si no
				return false;
			}
			return true;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<Viideojuego> videojuegoSelect(Statement st) {
		String sentSQL = "";
		ArrayList<Viideojuego> videojuegos= new ArrayList<>();
		try {
			sentSQL = "select * from videojuego";
			
			ResultSet rs = st.executeQuery(sentSQL);
			
			while(rs.next()) {
				videojuegos.add(new Viideojuego(rs.getInt("id"), rs.getString("nombre"),rs.getString("genero"),rs.getDouble("precio")));
			}
			rs.close();
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
		return videojuegos;
	}

	/* public static Object videojuegoSelect(Statement st, Viideojuego v, String genero_nombre, int id,
			String videojuego_nombre, String marca, String plataforma, String descripcion, int edad, double precio,
			String codigoSelect) {
		if (v == null || genero_nombre == null || genero_nombre.isEmpty())
			return null;
		String sentSQL = "";
		try {
			sentSQL = "select * from videojuego";
			if (v != null) {
				String where = "genero_nombre='" + genero_nombre + "' AND videojuego_nombre='" + v.getNombre() + "'"
						+ "' AND marca='" + v.getMarca() + "'" + "' AND plataforma='" + v.getPlataforma() + "'"
						+ "' AND descripcion='" + v.getDescripcion() + "'" + "' AND edad='" + v.getEdad() + "'"
						+ "' AND precio='" + v.getPrecio() + "'";
				if (codigoSelect != null && !codigoSelect.equals(""))
					sentSQL = sentSQL + " where " + where + " AND " + codigoSelect;
				else
					sentSQL = sentSQL + " where " + where;
			}
			if (codigoSelect != null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			ResultSet rs = st.executeQuery(sentSQL);
			rs.close();
			return rs;
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
*/
	
//  Metodos privados

	private static String securizar(String string) { // comprobar que el string añadido tiene caracteres coherentes
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúüÁÉÍÓÚÚ.,:;-_(){}[]-+*=<>'\"¿?¡!&%$@#/\\0123456789"
					.indexOf(c) >= 0)
				ret.append(c);
		}
		return ret.toString();
	}
	


}
