package Principales;

public class Alumno extends Persona{

	private String intolerancia;

	public Alumno(String dni, String nombre, String apellido, String birthdate, String sexo, String ciudad,
			String intolerancia) {
		
		super(dni, nombre, apellido, birthdate, sexo, ciudad);
		this.intolerancia = intolerancia;
	}

	public String getIntolerancia() {
		return intolerancia;
	}

	public void setIntolerancia(String intolerancia) {
		this.intolerancia = intolerancia;
	}
	
	
	
	




}
