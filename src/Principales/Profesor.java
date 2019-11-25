package Principales;

public class Profesor extends Persona {

	private String contrasena;
	private String telefono;

	public Profesor(String dni, String nombre, String apellido, String birthdate, String sexo, String ciudad,
			String contrasena, String telefono) {

		super(dni, nombre, apellido, birthdate, sexo, ciudad);
		this.contrasena = contrasena;
		this.telefono = telefono;
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
