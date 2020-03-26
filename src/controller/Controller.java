package controller;

import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;

	private View view;

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		
		while( !fin ){

			view.printMenu();

			int option = lector.nextInt();
			switch(option){

				case 1:
					
					break;
					
				default: 
					view.printMessage("------------- Opci�n invalida!! ---------- ");
					break;
			}
		}
		
	}	
}
