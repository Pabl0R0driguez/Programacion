package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		
		public static int obtenerSaldo(String usuario) {
			
			String sentenciaSaldo(" SELECT (SELECT sum(importe) from Operaciones WHERE movimiento ="Ingreso" and usuario="usuario1") - (SELECT sum(importe)from Operaciones
						     WHERE movimiento ="Gasto"  and usuario="usuario1") as "Saldo";"")
			
			return 0;
			
		}
						 
				
	}

	


