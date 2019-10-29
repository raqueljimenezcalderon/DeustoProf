package Principales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBD {

	private Connection conn = null;

	/**
	 * Crea una conexión con la base de datos.
	 * @throws DBException Se produce cuando existe un problema con la creación de la conexión a la BD.
	 */
	
	public void conectar() throws BDException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:datos/DeustoProf.bd");
		} catch (ClassNotFoundException e) {
			throw new BDException("No se ha podido cargar el driver de la BD", e);
		} catch (SQLException e) {
			throw new BDException("No se ha podido conectar a la BD", e);
		}
	}
	
	
	/**
	 * Cierra una conexión con la BD.
	 * @throws DBException Se produce cuando existe un error a la hora de conectar con la BD.
	 */
	public void desconectar() throws BDException {
		try {
			if (conn != null) { //esto no está en su ejemplo
				conn.close();
			}
		} catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la base de datos", e);
		}
	}
	
	/**
	 * Crea la tabla 'profesor' si no existe
	 * @throws DBException Se produce cuando existe un error en la creación de la tabla 'user'
	 */
	
	public void createPofesorTable() throws BDException {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS profesor (nombre_usu VARCHAR, nombre VARCHAR, apellido VARCHAR, birthdate VARCHAR, sexo VARCHAR, ciudad VARCHAR, contrasena VARCHAR, telefono VARCHAR)");
		} catch (SQLException e) {
			throw new BDException("Error creando la tabla 'profesor' en la BD", e);
		}
	}
	
	
	
}
