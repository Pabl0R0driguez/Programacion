package Repositorio;

import java.sql.SQLException;

public class FuncionesRegistro {

	public static int registro(String usuario, String contraseña, ConexionMySQL conexion) throws SQLException  {
		

		System.out.println("Repositorio: consultando a la base de datos. usuario: " + usuario + " contraseña: " + contraseña);
		
		
// comprobar si el usuario y la contraseña existen en la base de datos String
String sentenciaRegistro = "INSERT INTO Usuarios( usuario, contraseña) "
						+ " VALUES ('" + usuario + "','" + contraseña + "');"; 
		  


 int numfilas = conexion.ejecutarInsertDeleteUpdate(sentenciaRegistro);
 
 return numfilas;



	}
	}

	

