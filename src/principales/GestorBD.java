package principales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorBD {

	private static Exception lastError = null;
	private static Connection conn = null;
	private static Statement statement;

	/**
	 * Crea una conexi�n con la base de datos.
	 * 
	 * @throws DBException Se produce cuando existe un problema con la creaci�n de
	 *                     la conexi�n a la BD.
	 */

	public static Connection iniciarConexion() throws BDException {
		try {
			//Class.forName("org.sqlite.JDBC");
			//conn = DriverManager.getConnection("jdbc:sqlite:DeustoProf.bd");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			log(Level.INFO, "Iniciada la conexion con la BD", null);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new BDException("No se ha podido cargar el driver de la BD", e);
		} catch (SQLException e) {
			throw new BDException("No se ha podido conectar a la BD", e);
		}
	}
	
	// Statement para usar la base de datos
	public static Statement usarBD(Connection con) {
		try (Statement statement = con.createStatement();) {
			
			statement.setQueryTimeout(30);
			log(Level.INFO, "Base de datos funcionando correctamente", null);
			return statement;
			
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en uso de base de datos", e);
			return null;
		}
	}

	/**
	 * Cierra una conexi�n con la BD.
	 * 
	 * @throws DBException Se produce cuando existe un error a la hora de conectar
	 *                     con la BD.
	 */
	public static void desconectar() throws BDException {
		try {
			if (conn != null) { // esto no est� en su ejemplo
				conn.close();
				log(Level.INFO, "Cierre de base de datos", null);
				
			}
		} catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la base de datos", e);
		}
	}

	/**
	 * Crea la tabla 'profesor', 'alumno','asigantura', 'matricula' si no existen
	 * 
	 * @throws DBException Se produce cuando existe un error en la creaci�n de la
	 *                     tabla 'profesor'
	 */
	// Crea la tabla 'profesor' si no existe
	public static Statement createPofesorTable() throws BDException {
		try (Statement stmt = conn.createStatement()) {
			
			stmt.executeUpdate(
					"create table if not exists profesor (dni_profe VARCHAR primary key, nombre VARCHAR, apellido VARCHAR, birthdate VARCHAR, sexo VARCHAR, ciudad VARCHAR, contrasena VARCHAR, telefono VARCHAR)");
			log(Level.INFO, "Creacion de la tabla profesor", null);
			return stmt;
			
		
		} catch (SQLException e) {
			throw new BDException("Error creando la tabla 'profesor' en la BD", e);
		}
	}

	// Crea la tabla 'alumno' si no existe
	public static Statement createAlumnoTable() throws BDException {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"create table if not exists alumno (dni_alumno VARCHAR primary key, nombre VARCHAR, apellido VARCHAR, birthdate VARCHAR, sexo VARCHAR, ciudad VARCHAR, intolerancia VARCHAR)");
			log(Level.INFO, "Creacion de la tabla alumno", null);
			return stmt;
		} catch (SQLException e) {
			throw new BDException("Error creando la tabla 'alumno' en la BD", e);
		}
	}

	// Crea la tabla 'asignatura' si no existe
	public static Statement createAsignaturaTable() throws BDException {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"create table if not exists asignatura (cod_asig VARCHAR primary key, nombre VARCHAR, descripcion VARCHAR)");
			log(Level.INFO, "Creacion de la tabla asignatura", null);
			return stmt;
		} catch (SQLException e) {
			throw new BDException("Error creando la tabla 'asignatura' en la BD", e);
		}
	}

	// Crea la tabla 'matricula' si no existe

	public static Statement createMatriculaTable() throws BDException {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"create table if not exists matricula (dni_alumno VARCHAR, cod_asig VARCHAR, nota VARCHAR, primary key(dni_alumno, cod_asig))");
			log(Level.INFO, "Creacion de la tabla matricula", null);
			return stmt;
		} catch (SQLException e) {
			throw new BDException("Error creando la tabla 'matricula' en la BD", e);
		}
	}
	
	//Guardar usuario
	public void guardarProfesor(Profesor p) throws BDException {
		String sql = "INSERT INTO profesor VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) { // el preparestatement gestiona esos "?"
			// rellenamos los valores de la plantilla
			stmt.setString(1, p.getdni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getBirthdate());
			stmt.setString(5, p.getSexo());
			stmt.setString(6, p.getCiudad());
			stmt.setString(7, p.getContrasena());
			stmt.setString(8, p.getTelefono());

			/*Para las sentencias Insert, Update y Delete se utiliza el metodo
			 * executeUpdate(con nada aqui dentro porque sobreescribe la sentencia SQL)
			 * Para las Select se utiliza el metodo executeQuery();			
			*/
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new BDException("Error al guardar los datos del profesor", e);
		}
	}
	public void guardarAlumno(Alumno a) throws BDException {
		String sql = "INSERT INTO alumno VALUES (?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) { // el preparestatement gestiona esos "?"
			// rellenamos los valores de la plantilla
			stmt.setString(1, a.getdni());
			stmt.setString(2, a.getNombre());
			stmt.setString(3, a.getApellido());
			stmt.setString(4, a.getBirthdate());
			stmt.setString(5, a.getSexo());
			stmt.setString(6, a.getCiudad());
			stmt.setString(7, a.getIntolerancia());
			

			/*Para las sentencias Insert, Update y Delete se utiliza el metodo
			 * executeUpdate(con nada aqui dentro porque sobreescribe la sentencia SQL)
			 * Para las Select se utiliza el metodo executeQuery();			
			*/
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new BDException("Error al guardar los datos del profesor", e);
		}
	}
	
	// Logger
	private static Logger logger = null;

	public static void setLogger(Logger logger) {
		GestorBD.logger = logger;
	}

	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger == null) {
			logger = Logger.getLogger(GestorBD.class.getName());
			logger.setLevel(Level.ALL);
			try {
				logger.addHandler(new FileHandler("bd.log.xml", true));
			} catch (Exception e) {
				logger.log(Level.SEVERE, "No se pudo crear fichero de log", e);
			}
		}
		if (excepcion == null) {
			logger.log(level, msg);
		} else {
			logger.log(level, msg, excepcion);
		}
	}
	
	
	public static int login(String nDNI, String contrasena) {
		String sql = "Select dni_profe, contrasena from profesor where dni_profe = ? and contrasena = ?";

		try (//Conectarse a la bbdd
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
				//Preparar la sentencia SQL
				PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);){
			//Introducir los parametros recibidos en la sentencia SQL
			st.setString(1, nDNI);
			st.setString(2, contrasena);
			
			//Ejecuta la sentencia y devuelve un resultado
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("Has iniciado sesion con exito");
				return 0;
			} else {
				System.out.println("Usuario o contrase�a incorrecto");
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
	
		
	}

	public static ArrayList<Alumno> visualizarAlumno() {
		String dni, nombre, apellido, birthdate, sexo, ciudad, intolerancia;
		String sql = "Select dni_alumno, nombre, apellido, birthdate, sexo, ciudad, intolerancia from alumno";
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); ){
			while(rs.next()) {
				
				dni = rs.getString("dni_alumno");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				birthdate = rs.getString("birthdate");
				sexo = rs.getString("sexo");
				ciudad = rs.getString("ciudad");
				intolerancia = rs.getString("intolerancia");
				
				
				
				alumnos.add(new Alumno(dni, nombre, apellido, birthdate, sexo, ciudad, intolerancia));
				
			} 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	public static ArrayList<Asignatura> visualizarAsignatura() {
		String cod_asig, nombre, descripcion;
		String sql = "Select cod_asig, nombre, descripcion from asignatura";
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		
		try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); ){
			while(rs.next()) {
				
				cod_asig = rs.getString("cod_asig");
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
				
				
				
				asignaturas.add(new Asignatura(cod_asig, nombre, descripcion));
				
			} 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asignaturas;
		
	}
	
	public static ArrayList<Matricula> visualizarMatricula() {
		String cod_asig, dni_alumno;
		String nota;
		String sql = "Select dni_alumno, cod_asig, nota from matricula";
		ArrayList<Matricula> matriculas = new ArrayList<>();
		
		try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); ){
			while(rs.next()) {
				
				cod_asig = rs.getString("cod_asig");
				dni_alumno = rs.getString("dni_alumno");
				nota = rs.getString("nota");
				
				
				
				matriculas.add(new Matricula(cod_asig, dni_alumno, nota));
				
			} 			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matriculas;
		
	}
	
	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		GestorBD.conn = conn;
	}

}
