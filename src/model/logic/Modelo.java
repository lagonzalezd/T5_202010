package model.logic;


import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Node;
import model.data_structures.Queue;
import model.data_structures.Stack;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * Definicion del modelo del mundo
 *
 */
	public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	private IQueue<Comparendo> colaDatos;
	private IStack<Comparendo> pilaDatos;
	private int elementosCargadosPila;
	private int elementosCargadosCola;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	public static String PATH_MIL = "./data/milDatos.geojson";
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		colaDatos = new Queue<Comparendo>();
		pilaDatos = new Stack<Comparendo>();
		int elementosCargadosCola = 0;
		int elementosCargadosPila = 0;

	}

	// Solucion de carga de datos publicada al curso Estructuras de Datos 2020-10 
	public Stack<Comparendo> cargarDatosPila() {
		pilaDatos = new Stack<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			
			
			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, DES_INFRAC, LOCALIDAD, longitud, latitud);
				pilaDatos.push(c);
				elementosCargadosPila++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return (Stack<Comparendo>) pilaDatos;	
		
	}
	// Solucion de carga de datos publicada al curso Estructuras de Datos 2020-10 
	public Queue<Comparendo> cargarDatosCola() {
		colaDatos = new Queue<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			
			
			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, DES_INFRAC, LOCALIDAD, longitud, latitud);
				colaDatos.enQueue(c);
				elementosCargadosCola++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return (Queue<Comparendo>) colaDatos;	
		
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoCola()
	{
		return colaDatos.darTamano();
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoPila()
	{
		return pilaDatos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarPila(Comparendo dato)
	{	
		pilaDatos.push(dato);
	}
	
	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarCola(Comparendo dato)
	{	
		colaDatos.enQueue(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public int buscarCola(T pElemento)
	{
		return 0;
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return indice encontrado
	 */
	public int buscarPila(Comparendo pElemento)
	{
		return 0;
	}
	
	/**
	 * Requerimiento eliminar dato de la cola
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public void eliminarCola()
	{
		colaDatos.deQueue();
	}
	/**
	 * Requerimiento eliminar dato de la pila
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public void eliminaPila()
	{
		try {
			pilaDatos.pop();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public int getElementosCargadosPila() {
		return elementosCargadosPila;
	}

	public int getElementosCargadosCola() {
		return elementosCargadosCola;
	}

	public Queue<Comparendo> buscarGrupoMasGrandeCola(Queue<Comparendo> datos3) {
		int contadorMenor = 0;
		int contadorMayor = 0;
		Queue<Comparendo> colaMenor = new Queue<Comparendo>();
		Queue<Comparendo> colaMayor = new Queue<Comparendo>();
		
		boolean finCiclo = false;
		
		
		while (!finCiclo) {
			if( datos3.estaVacia() ) {
				finCiclo = true;
			}
			else {
				//sacar elemento de la cola
				Comparendo temporal = datos3.deQueue();
				//Si es el primero	
				if( colaMenor.estaVacia() ) {
						colaMenor.enQueue(temporal);
						contadorMenor++;
				}
				//Si ya hay algo en menor y tienen los mismos codigos
				else if (temporal.getCodigoInfraccion().equalsIgnoreCase(colaMenor.peek().getCodigoInfraccion()) == true) {
						colaMenor.enQueue(temporal);
						contadorMenor++;
				}
				//Si ya hay algo en menor pero tiene distintos codigos
				else if ( temporal.getCodigoInfraccion().equalsIgnoreCase(colaMenor.peek().getCodigoInfraccion()) == false ){
						if(contadorMenor > contadorMayor)
							colaMayor = colaMenor;
							colaMenor = new Queue<Comparendo>();
							contadorMayor = contadorMenor;
							contadorMenor = 0;
							
							colaMenor.enQueue(temporal);
							contadorMenor++;
						}
						else {
							colaMenor = new Queue<Comparendo>();
							contadorMenor = 0;
				}
			}
		}
		return colaMayor;	
	}


	public Stack<Comparendo> buscarUltimosNPila(Stack<Comparendo> datos4, int pN, String codigo) {
		Stack<Comparendo> pila = new Stack<Comparendo>();
		boolean finCiclo = false;
		int contador = 0;
		while (!finCiclo) {
			if( datos4.estaVacia() || contador == pN ) {
				finCiclo = true;
			}
			else {
				Comparendo temporal = datos4.pop();
				if( temporal.getCodigoInfraccion().equalsIgnoreCase(codigo) ) {
					pila.push(temporal);
					contador++;
				}
			}
			
		}
		return pila;
		
	}



}
