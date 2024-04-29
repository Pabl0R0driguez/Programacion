package Repositorio;

import java.sql.SQLException;

public class FuncionesCategorias {

	public static int añadirCategorias(String nombre , ConexionMySQL conexion) throws SQLException {
		String sentenciaCategorias = "INSERT INTO Categorias(nombre) "
				+ " VALUES ('" +nombre+"');"; 
		
		int numfilas = conexion.ejecutarInsertDeleteUpdate(sentenciaCategorias);		 
		 return numfilas;
		
		
	}
}
