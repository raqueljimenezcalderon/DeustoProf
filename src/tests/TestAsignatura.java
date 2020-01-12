package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import principales.Asignatura;

public class TestAsignatura {

	
	//comprueba los getters y setters de la clase Asignatura
	@Test
	public void testgetNombreAsignatura() {
		Asignatura asignatura = new Asignatura("1","Matematicas", "Es una asignatura donde...");
		
		assertSame("Matematicas", asignatura.getNombreAsignatura());
	}
	@Test
	public void testsetNombreAsignatura() {
		Asignatura asignatura = new Asignatura("1","Matematicas", "Es una asignatura donde...");
		asignatura.setNombreAsignatura("Plastica");
		assertSame("Plastica", asignatura.getNombreAsignatura());
	}
	
	@Test
	public void testgetDescripcion() {
		Asignatura asignatura = new Asignatura("1","Matematicas", "Es una asignatura donde...");
		
		assertSame("Es una asignatura donde...", asignatura.getDescripcion());
	}
	@Test
	public void testsetDescripcion() {
		Asignatura asignatura = new Asignatura("1","Matematicas", "Es una asignatura donde...");
		asignatura.setDescripcion("No es una asignatura artis...");
		
		assertSame("No es una asignatura artis...", asignatura.getDescripcion());
	}

}
