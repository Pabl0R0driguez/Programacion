package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FuncionesInicioSesion {

	// comprobar el usuario y contraseña introducidos.
	//Si el usuario existe devuelve true sino false.
	public static boolean login(String usuario, String contraseña, ConexionMySQL conexion) throws SQLException  {
		  String resultadoNombre = "";
		  String resultadoContraseña = "";
		  System.out.println("usuario login: " + usuario + " contra: " + contraseña);
			System.out.println("Repositorio: consultando a la base de datos. usuario: " + usuario + " contraseña: " + contraseña);
			
			
	// comprobar si el usuario y la contraseña existen en la base de datos String
	String sentencia = "SELECT usuario, contraseña FROM Usuarios	WHERE usuario = '" + usuario + "' and contraseña='" + contraseña + "';" ; 
			  
			  
			  
			  ResultSet datos; 
			  //Comprobación  de nombre
			  datos = conexion.ejecutarSelect(sentencia);
			  while(datos.next()) {
				  // Consulta del nombre 
				  resultadoNombre = datos.getString("usuario");//nombre del campo en la base de datos
				  resultadoContraseña = datos.getString("contraseña");//nombre del campo en la base de datos

				  System.out.println("RESULTADO USUARIO: " + resultadoNombre + " contra: " + resultadoContraseña);
			  }
			 
			 
			  if(!resultadoNombre.equals("") && (!resultadoContraseña.equals(""))) {
				  System.out.println("El usuario existe");
				  return true;
			  }
			  	return false;
			 
			
	}

}
