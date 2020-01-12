package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import principales.Alumno;

public class TestAlumno {

	// comprueba que los getter y setters de la clase Alumno funcionan correctamente

	Alumno alumno = new Alumno("79066277M", "Raquel", "Jimenez", "19/05/1998", "F", "Bilbao", "ninguna");

	@Test
	public void testgetDni() {
		assertSame("79066277M", alumno.getdni());
	}

	@Test
	public void testsetDni() {

		alumno.setdni("79066277X");
		assertSame("79066277X", alumno.getdni());
	}

	@Test
	public void testgetApellido() {

		assertSame("Jimenez", alumno.getApellido());
	}

	@Test
	public void testsetApellido() {

		alumno.setApellido("Zabala");
		assertSame("Zabala", alumno.getApellido());
	}

	@Test
	public void testgetBirthdate() {

		assertSame("19/05/1998", alumno.getBirthdate());
	}

	@Test
	public void testsetBirthdate() {

		alumno.setBirthdate("19/95/2000");
		assertSame("19/95/2000", alumno.getBirthdate());
	}

	@Test
	public void testgetCiudad() {

		assertSame("Bilbao", alumno.getCiudad());
	}

	@Test
	public void testsetCiudad() {

		alumno.setCiudad("Baracaldo");
		assertSame("Baracaldo", alumno.getCiudad());
	}

}
