package Principales;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private String sexo;
	private String ciudad;
	
	public Persona(String nombre, String apellido, int edad, String sexo, String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo = sexo;
		this.ciudad = ciudad;
	}

	public Persona() {
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.sexo = "";
		this.ciudad = "";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
