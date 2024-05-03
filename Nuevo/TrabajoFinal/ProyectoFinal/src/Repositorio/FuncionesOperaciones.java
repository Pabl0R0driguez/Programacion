package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Modelo.Transaccion;
import Vista.Operaciones;
import Vista.Transacciones;

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
		public static int obtenerSaldo(String usuario, ConexionMySQL conexion) throws SQLException {
			String resultadoGastos="", resultadoIngresos="";
			
			
			//////////////////////////   Sentencias SQL para obtener gastos e ingresos del usuario  //////////////////////
			
			String sentenciaGasto = "SELECT sum(importe) AS SumaGastos "
			+ "FROM `Operaciones` WHERE movimiento='Gasto' AND usuario ='" + usuario + "';" ;
			
			String sentenciaIngreso ="SELECT sum(importe) AS SumaIngresos "
			+ "FROM `Operaciones` WHERE movimiento='Ingreso' AND usuario = '" + usuario + "';" ;
		
			
			
			
			////////////////////////////   Consulta de Gastos  ///////////////////////////////
			//El resultado de la consulta a la base de datos se guarda en el ResultSet
			ResultSet Gastos; 
			//Obtención de gastos del usuario
			Gastos = conexion.ejecutarSelect(sentenciaGasto);
			  while(Gastos.next()) {
				  // Consulta de los gastos 
				 resultadoGastos = Gastos.getString("SumaGastos");//nombre del campo de la columna en la base de datos
				  System.out.println("Total gastos: " + resultadoGastos);
			  }
			  
			  
			  
			////////////////////////////Consulta de Ingresos  ///////////////////////////////  
			ResultSet Ingreso; 
			  
			//Consulta de ingresos del usuario
			Ingreso = conexion.ejecutarSelect(sentenciaIngreso);
			  while(Ingreso.next()) {
				  // Consulta del nombre 
				  resultadoIngresos = Ingreso.getString("SumaIngresos");//nombre del campo de la columna en la base de datos
				  System.out.println("Total ingresos: " + resultadoIngresos);
			  }
			  
			  /////////////////////////////Saldo Total////////////////////////////
 //Pasamos las variables String a entero para poder operar con ellas y obtener el saldo final
			  int TotalIngresos=0;
			  int TotalGastos=0;

			  if(resultadoIngresos!=null) {			
				  TotalIngresos= Integer.parseInt(resultadoIngresos);
			  }
			  if(resultadoGastos!=null) {
				  TotalGastos = Integer.parseInt(resultadoGastos);
			  		  
			  }
			  return TotalIngresos - TotalGastos; 
		}
		
		
		
		
		//////////////////////////////
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
		
		
		public static ArrayList<Transaccion> Historial(String usuario,ConexionMySQL conexion) throws SQLException {
			String sentenciaImporte = "SELECT movimiento, metodopago, importe, notas, usuario, Categoria FROM Operaciones where usuario="+"'"+usuario+"';";
			
			ArrayList<Transaccion> resultadoHistorial= new ArrayList<>();
			
			// campos de cada transacción
			String movimiento,metodopago,importe, notas, Categoria;
			Transaccion transaccion;
			
			
			ResultSet Transacciones; 
			//Obtención de Transacciones del usuario
			Transacciones = conexion.ejecutarSelect(sentenciaImporte);
			  while(Transacciones.next()) {
				  // Consulta de ls Transacciones 
				  
				  movimiento = Transacciones.getString("movimiento"); 
				  metodopago = Transacciones.getString("metodopago"); 
				  importe = Transacciones.getString("importe"); 
				  notas = Transacciones.getString("notas"); 
				  Categoria = Transacciones.getString("Categoria"); 
				  
				  transaccion =  new Transaccion(movimiento,metodopago,importe, notas, usuario,Categoria);
				  resultadoHistorial.add(transaccion);		
				  
				  }
			  return resultadoHistorial;
}
		
///////////////////////??		
		public static String Filtrar() throws SQLException {
			String resultadoBusqueda=Vista.Transacciones.FiltrarValor.getText();				
			
			return resultadoBusqueda;
		
}
		
		//Actualizar nombre usuario
		public static void actualizar(String nuevoUsuario,ConexionMySQL conexion) throws SQLException {
			String CambiarUsuario = "UPDATE Usuarios  SET usuario = '" + nuevoUsuario+ "' WHERE usuario = '" 
		+ Vista.InicioSesion.UsuarioValor.getText() + "'";
					
			conexion.ejecutarInsertDeleteUpdate(CambiarUsuario);
			
		}
		
		
		public static int BorrarCategoria(String categoria, ConexionMySQL conexion) throws SQLException {
			
			String sentenciaBorrar = "DELETE FROM Categorias WHERE Nombre = '" + categoria + "';";
			String sentenciaConsulta = "SELECT Nombre FROM Categorias WHERE Nombre= '" + categoria + "';"; 
			String resultado = "";
			
			
			
			/////// Consulta de la categoría a borrar 
		
			ResultSet borrar; 
			  //Comprobación  de nombre
			borrar = conexion.ejecutarSelect(sentenciaConsulta);
			  while(borrar.next()) {
				  // Consulta del nombre 
				  resultado = borrar.getString("Nombre");//nombre del campo en la base de datos
			  }
			  //
			  if(resultado.equals(categoria)) {
				  int fila=
					conexion.ejecutarInsertDeleteUpdate(sentenciaBorrar);
System.out.println("fila: "+ fila);
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "La categoria no existe",
		  					"Error", JOptionPane.ERROR_MESSAGE);
			  }
				return 0;
	  
}
}

		

	
	
	


