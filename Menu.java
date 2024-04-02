package Ejercicio1;

import java.util.Scanner;

public class Menu {

	Scanner teclado = new Scanner(System.in);
	int numero=teclado.nextInt();
	
	
	public static void Menu() {
		
			
		System.out.println("----MENÚ------");		
		System.out.println("1-Inserción de Datos");			
		System.out.println("2-Consulta de Datos");			
		System.out.println("3-Actualización de Datos");			
		System.out.println("4-Borrado de Datos");
	}
		

}
