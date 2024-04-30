package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import Vista.Operaciones;

public class FuncionesOperaciones {
	// comprobar los datos introducidos.
		
		public static int anadir(String importe, String metodo, String categoria, String nota , String operacion,String usuario, ConexionMySQL conexion) throws SQLException  {
			

				System.out.println("Repositorio: consultando a la base de datos. importe: " + importe + " metodo: " + metodo + 
						" categoria: " + categoria + " 	nota: " + nota + " operación: " + operacion + " usuario: " + usuario );
				
				
		// comprobar si el usuario y la contraseña existen en la base de datos String
		String sentenciaImporte = "INSERT INTO Operaciones( movimiento, metodopago, importe, notas, usuario, Categoria) "
								+ " VALUES ('" + operacion + "','" + metodo + "'," + importe + ", '" + nota + "','" + usuario + "', '" + categoria+"');"; 
				  		
		
		 int numfilas = conexion.ejecutarInsertDeleteUpdate(sentenciaImporte);		 
		 return numfilas;		
	}
			
	//Obtener saldo
		public static int obtenerSaldo(ConexionMySQL conexion) throws SQLException {
			
			String resultadoGastos="";
			String resultadoIngreso="";
			
			String sentenciaGasto = "SELECT sum(importe) AS SumaGastos FROM `Operaciones` WHERE movimiento='Ingreso'";

			String sentenciaIngreso ="SELECT sum(importe) AS SumaIngresos FROM `Operaciones` WHERE movimiento='Gasto'";
		
			
			
			ResultSet Gastos; 
			//Obtención de gastos
			Gastos = conexion.ejecutarSelect(sentenciaGasto);
			  while(Gastos.next()) {
				  // Consulta del nombre 
				  resultadoGastos = Gastos.getString("SumaGastos");//nombre del campo en la base de datos
				  System.out.println("RESULTADO USUARIO: " + resultadoGastos);
			  }
			  
			  
			ResultSet Ingreso; 
			  
			//Comprobación de contraseñaDO
			Ingreso = conexion.ejecutarSelect(sentenciaIngreso);
			  while(Ingreso.next()) {
				  // Consulta del nombre 
				  resultadoIngreso = Ingreso.getString("SumaIngresos");//nombre del campo en la base de datos
				  System.out.println("RESULTADO CONTRASEÑA: " + resultadoIngreso);
			  }
			  return 0; // resultadoIngreso - resultadoGastos;
		}
		
		public static ArrayList<String> leerCategorias(ConexionMySQL conexion ) throws SQLException {
			String sentenciaCategorias = "SELECT Nombre FROM Categorias";
			ArrayList<String> resultado = new ArrayList<>();
			
			 ResultSet datos; 
			  //Comprobación  de nombre
			  datos = conexion.ejecutarSelect(sentenciaCategorias);
			  while(datos.next()) {
				  // Consulta del nombre 
				  resultado.add(datos.getString("Nombre"));//nombre del campo en la base de datos
			  }
			return resultado;		
			}
		
}

				
	

	


