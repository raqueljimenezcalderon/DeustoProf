package principales;

public class Matricula {
	
	private String nota;
	private String cod_asig, dni_alumno;
	
	public Matricula() {
		super();
		this.cod_asig = "";
		this.dni_alumno = "";
		this.nota = "";
	}
	
	public Matricula(String cod_asig, String dni_alumno, String nota) {
		this();
		this.cod_asig = cod_asig;
		this.dni_alumno = dni_alumno;
		this.nota = nota;
	}
	

	
	public String getCod_asig() {
		return cod_asig;
	}

	public void setCod_asig(String cod_asig) {
		this.cod_asig = cod_asig;
	}

	public String getDni_alumno() {
		return dni_alumno;
	}

	public void setDni_alumno(String dni_alumno) {
		this.dni_alumno = dni_alumno;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Matricula [nota=" + nota + ", cod_asig=" + cod_asig + ", dni_alumno=" + dni_alumno + "]";
	}
	
}
