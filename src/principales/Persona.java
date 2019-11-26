package principales;

public class Persona {

	private String dni;
	private String nombre;
	private String apellido;
	private String birthdate;
	private String sexo;
	private String ciudad;
	
	
	public Persona(String dni, String nombre, String apellido, String birthdate, String sexo, String ciudad) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.birthdate = birthdate;
		this.sexo = sexo;
		this.ciudad = ciudad;
	}
	/*
	public Persona() {
		this.dni = "";
		this.nombre = "";
		this.apellido = "";
		this.birthdate = "";
		this.sexo = "";
		this.ciudad = "";
	}*/
	
	public String getdni() {
		return dni;
	}
	public void setdni(String dni) {
		this.dni = dni;
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
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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
