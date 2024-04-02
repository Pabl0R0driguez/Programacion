package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Conexión
		ConexionMySQL conect = new ConexionMySQL("root" , "test" ,"Prueba");
		Scanner sc = new Scanner (System.in); 
		
		//Conectar
		try {
			conect.conectar();
			//Introducir tantos datos como deseemos en la base de datos
			
			  System.out.println("Introduzca un nombre:"); 
			  String nuevoNombre=sc.next();
			  System.out.println("Introduzca un apellido:"); 
			  String nuevoApellido=sc.next(); 
			  System.out.println("Introduzca un DNI:"); 
			  String nuevoDNI=sc.next(); 
			  System.out.println("Introduzca edad:"); 
			  String nuevaEdad=sc.next();
			  
			  //Añadimos datos a la tabla String sentencia =
		String sentencia = "INSERT INTO Personas(Nombre, Apellido, DNI ,Edad) VALUES('" + nuevoNombre + "' , '" + nuevoApellido + "' , '" + nuevoDNI + "' '" + nuevaEdad + "'  )";
			  conect.ejecutarInsertDeleteUpdate(sentencia);
			 
			  
			
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Desconectar
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
