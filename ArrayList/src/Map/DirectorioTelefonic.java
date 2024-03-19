package Map;

import java.util.Scanner;

public class DirectorioTelefonic {

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int numero = sc.nextInt();
	System.out.println("Introduce un numero del 1 al 4");
	
	do {
		switch(numero) {
	
		case 1:
			System.out.println("Agregar nuevos contactos");
		break;
		
		case 2:
			System.out.println("Buscar un número de telefono por su nombre");
			break;
		
		case 3:
			System.out.println("Eliminar un contacto por nombre");
			break;
			
		case 4:
			System.out.println("Mostrar todos los contactos en el directorio");
			break;
		}
	
		
	}while(numero<=4);
		
	}
}