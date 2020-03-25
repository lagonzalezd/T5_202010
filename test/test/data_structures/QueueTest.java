package test.data_structures;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.logic.Comparendo;

public class QueueTest {
	
	private Queue colaDatos;
	private Comparendo objeto1;
	private Comparendo objeto2;
	private Comparendo objeto3;
	private Comparendo objeto4;
	private int numero;
	private String texto;
	private Date fecha;
	
	@Before
	public void setUpEscenario() throws Exception {
		
		colaDatos = new Queue();
		fecha = new Date();
		objeto1 = new Comparendo(29042, fecha, "DEAP", "Automovil", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "Barrios Unidos", 1.02, 1.22);
		objeto2 = new Comparendo(509329, fecha, "LAPIZ", "Camioneta", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL" , "Tunjuelito", 1.02, 1.22);
		objeto3 = new Comparendo(519553, fecha, "LAPIZ", "Motocicleta", "Particular", "B02", "LICENCIA VENCIDA", "Bosa", 1.02, 1.22);
		objeto4 = new Comparendo(176695, fecha, "DEAP", "Automovil", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "Teusaquillo", 1.02, 1.22);
		numero = 1400030394; 
		texto = "ABCDF";
		
	}

	@Test
	public void enQueueTest1() {
		try {
			setUpEscenario();
			colaDatos.enQueue(numero);
			assertTrue("El elemento deber�a ser igual a 1400030394", Integer.valueOf((colaDatos.peek().toString())) == 1400030394);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void enQueueTest2() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto1);
			colaDatos.enQueue(numero);
			assertTrue("El elemento deber�a ser igual al id del objeto1", ((Comparendo)colaDatos.peek()).getId() == 29042);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void deQueueTest1() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto3);
			colaDatos.enQueue(numero);
			colaDatos.enQueue(objeto2);
			colaDatos.enQueue(texto);
			colaDatos.deQueue();
			assertTrue("El elemento deber�a ser igual a 1400030394", Integer.valueOf((colaDatos.peek().toString())) == 1400030394);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void deQueueTest2() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto3);
			colaDatos.enQueue(numero);
			colaDatos.enQueue(objeto2);
			colaDatos.enQueue(texto);
			colaDatos.deQueue();
			colaDatos.deQueue();
			assertTrue("El elemento deber�a ser igual al id del objeto2", ((Comparendo)colaDatos.peek()).getId() == 509329);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void deQueueTest3() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto3);
			colaDatos.enQueue(numero);
			colaDatos.enQueue(objeto2);
			colaDatos.enQueue(texto);
			colaDatos.deQueue();
			assertTrue("El metodo deber�a devolver el Object de tipo numero", colaDatos.deQueue().getClass() == Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void estaVaciaTest() {
		try {
			setUpEscenario();
			assertTrue("La cola deber�a estar vacia", colaDatos.estaVacia() == true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void estaVaciaTest2() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto4);
			colaDatos.deQueue();
			assertTrue("La cola deber�a estar vacia", colaDatos.estaVacia() == true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void estaVaciaTest3() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto4);
			colaDatos.deQueue();
			colaDatos.enQueue(objeto3);
			assertTrue("La cola no deber�a estar vacia", colaDatos.estaVacia() == false);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void darTamanoTest1() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto4);
			colaDatos.deQueue();
			colaDatos.enQueue(objeto3);
			colaDatos.enQueue(objeto2);
			colaDatos.enQueue(texto);

			assertTrue("La cola deber�a estar conteniendo 3 elementos", colaDatos.darTamano() == 3);
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	@Test
	public void peekTest1() {
		try {
			setUpEscenario();
			colaDatos.enQueue(objeto4);
			colaDatos.enQueue(objeto3);
			colaDatos.enQueue(objeto2);
			colaDatos.enQueue(texto);
			assertTrue("El primer elemento deber�a ser el objeto4", colaDatos.peek().equals(objeto4));
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}

}
