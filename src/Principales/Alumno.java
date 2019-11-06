package Principales;

public class Alumno extends Persona{

	private String dniAlumno;

	public Alumno(String dniAlumno, String nombre, String apellido, int edad, String sexo, String ciudad) {
		
		super(nombre, apellido, edad, sexo, ciudad);
		this.dniAlumno = dniAlumno;
	}
	
	public Alumno() {
		
		super();
		this.dniAlumno = "";
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

}
