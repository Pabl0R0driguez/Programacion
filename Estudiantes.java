package Ejercicio1;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import BBDD.ConexionMySQL;

public class Estudiantes {

	public static void main(String[] args) {

		ConexionMySQL conect = new ConexionMySQL("root" , "test" ,"Escuela");
		Scanner sc = new Scanner (System.in); 
		Menu.Menu();	
		

		
		//MENÚ
		
	try {
		 conect.conectar();
	
		Scanner teclado = new Scanner(System.in);
		int numero=teclado.nextInt();
		
			switch(numero) {
				
			case 1:
		  System.out.println("Introduzca un nombre:"); 
		  String nuevoNombre=sc.next();
		  System.out.println("Introduzca un edad:"); 
		  String nuevaEdad=sc.next();
		  System.out.println("Introduzca un DNI:");
		  String nuevoDNI=sc.next();
		  
		String sentencia="INSERT INTO Estudiantes(Nombre, Edad, DNI) VALUES ('" +
		nuevoNombre + "' , '" + nuevaEdad + "' , '" + nuevoDNI + "')";
		conect.ejecutarInsertDeleteUpdate(sentencia);

			break;
			case 2:
					
		//Muestra todos los datos de la BBDD
		String senten = "SELECT * FROM Estudiantes";
		conect.ejecutarSelect(senten);
		ResultSet datos;
		datos=conect.ejecutarSelect(senten);
			
			
		while(datos.next())
		{
			String nombre = datos.getString("Nombre");
			int edad=datos.getInt("Edad");			
			int dni = datos.getInt("DNI");
						
			System.out.println(nombre + " " + edad + " " + dni  );
		}
	
		//Busca por nombre y dni
		String buscar = "SELECT Nombre, DNI FROM Estudiantes";
		conect.ejecutarSelect(buscar);
		ResultSet datos1;
		datos1=conect.ejecutarSelect(buscar);
		
		while(datos.next())
		{
			String nombre = datos.getString("Nombre");
			int dni = datos.getInt("DNI");
		
			break;
			
		}
			
			
			case 3:
		
				
				
			break;
			case 4:
		
			break;
			
			default:
				
				break;
	
			}
		

	}
	catch(SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		

		finally
		{
		try {
			conect.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	}
}
	
