package test.data_structures;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.logic.Comparendo;

public class StackTest {
	
	private Stack pilaDatos;
	private Comparendo objeto1;
	private Comparendo objeto2;
	private Comparendo objeto3;
	private Comparendo objeto4;
	private int numero;
	private String texto;
	
	@Before
	public void setUp() throws Exception {
		pilaDatos = new Stack();
		Date fecha = new Date();
		objeto1 = new Comparendo(29042, fecha, "DEAP", "Automovil", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "Barrios Unidos", 1.02, 104);
		objeto2 = new Comparendo(509329, fecha, "LAPIZ", "Camioneta", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL" , "Tunjuelito", 1.02, 104);
		objeto3 = new Comparendo(519553, fecha, "LAPIZ", "Motocicleta", "Particular", "B02", "LICENCIA VENCIDA", "Bosa", 1.02, 104);
		objeto4 = new Comparendo(176695, fecha, "DEAP", "Automovil", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "Teusaquillo", 1.02, 104);
		numero = 1400394; 
		texto = "DEFG";
	}
	

	@Test
	public void pushTest() {
		try {
			setUp();
			pilaDatos.push(objeto4);
			pilaDatos.push(objeto2);
			pilaDatos.push(texto);
			assertTrue("Deberia ser igual al objeto texto", pilaDatos.peek().equals(texto));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void popTest() {
		try {
			setUp();
			pilaDatos.push(objeto4);
			pilaDatos.push(objeto2);
			pilaDatos.push(texto);
			assertTrue("Deberia eliminar y devolver el objeto texto", pilaDatos.pop().equals(texto));
			assertTrue("Deberia ser igual al objeto2", pilaDatos.peek().equals(objeto2));

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void estaVaciaTest() {
		try {
			setUp();
			pilaDatos.push(objeto4);
			pilaDatos.push(objeto2);
			pilaDatos.push(texto);
			assertTrue("No deberia estar vacia", pilaDatos.estaVacia() == false);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void darTamanoTest() {
		try {
			setUp();
			pilaDatos.push(objeto4);
			pilaDatos.push(objeto2);
			pilaDatos.push(texto);
			pilaDatos.pop();
			pilaDatos.push(objeto1);
			assertTrue("Deberpia tener 3 elementos", pilaDatos.darTamano() == 3);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void peekTest() {
		try {
			setUp();
			pilaDatos.push(objeto4);
			pilaDatos.push(objeto2);
			assertTrue("Deber�a ser el elemento objeto2", pilaDatos.peek().equals(objeto2) );
			pilaDatos.push(texto);
			pilaDatos.pop();
			pilaDatos.push(objeto1);
			assertTrue("Deberpia tener 3 elementos", pilaDatos.peek().equals(objeto1) );

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
