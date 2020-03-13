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
			System.out.println(" | 1. Cargar comparendos en Stack                             (OPCION 1)|");
			System.out.println(" | 2. Cargar comparendos en Queue                             (OPCION 1)|");
			System.out.println(" | 3. Buscar grupo consecutivo más grande en Queue            (OPCION 2)|");
			System.out.println(" | 4. Buscar ultimos comparendos en Stack                     (OPCION 3)|");
			System.out.println(" | 5. Imprimir Stack                                  (OPCION ADICIONAL)|");
			System.out.println(" | 6. Imprimir Queue                                   (OPCION ADICINAL)|");
			System.out.println(" | 7. Cerrar                                                            |");
			System.out.println(" |_Dar el numero de opcion a resolver, luego oprimir tecla Return:______| ");
			System.out.println(" ");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
