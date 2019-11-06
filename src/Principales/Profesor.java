package Principales;

public class Profesor extends Persona{

	private String nombreUsuario;
	private String contrasena;
	private String telefono;

	public Profesor(String nombreUsuario, String nombre, String apellido, int edad, String sexo, String ciudad,
			String contrasena, String telefono) {
		
		super(nombre, apellido, edad, sexo, ciudad);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.telefono = telefono;
	}
	
	public Profesor() {

		super();
		this.nombreUsuario = "";
		this.contrasena = "";
		this.telefono = "";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
