package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import principales.GestorBD;


public class TestGestorBD {

	
	//Comprueba que salta la excepción NullPointerException por pasarle una conexion erronea.
	@Test
	public void sqlExceptionTest() {
		boolean ok = true;
		Connection con = null;
		try {

			GestorBD.usarBD(con);
			ok = false;

		} catch (NullPointerException e) {
			ok = true;
		}
		assertEquals(true, ok);
	}
	


}
