package principales;

public class Asignatura {

	private String codAsignatura;
	private String nombreAsignatura;
	private String descripcion;

	public Asignatura(String codAsignatura, String nombreAsignatura, String descripcion) {
		
		this.codAsignatura = codAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.descripcion = descripcion;
	}
	
	public Asignatura() {
		
		this.codAsignatura = "";
		this.nombreAsignatura = "";
		this.descripcion = "";
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
