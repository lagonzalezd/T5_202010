package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println(" ");
			System.out.println("  ________________________________Opciones______________________________ ");
			System.out.println(" | 1. Cargar                          (OPCION 1)|");
			System.out.println(" ");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
