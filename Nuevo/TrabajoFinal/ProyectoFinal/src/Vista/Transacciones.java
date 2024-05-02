package Vista;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

import Modelo.Transaccion;
import Repositorio.ConexionMySQL;
import Repositorio.FuncionesOperaciones;

import java.awt.Toolkit;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Transacciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Historial;
	private JLabel lblNewLabel;
	private String usuario, operacion;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	private JTable table;
	private Button BotonVolver;
	public static JTextField FiltrarValor;
	private JLabel Filtrar;
	private JButton BuscarBoton;
	
	
	public Transacciones(String usuario, String operacion, ConexionMySQL conexion)  {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Transacciones.class.getResource("/Imagenes/hucha.png")));
		this.usuario=usuario;
		this.operacion=operacion;
		this.conexion=conexion;

		//initPantalla();
		// frame
	    JFrame f;
	    // Table
	    JTable j;
	 
	   
	        // Frame initialization
	        f = new JFrame();
	        f.getContentPane().setBackground(new Color(255, 255, 255));
	 
	        // Frame Title
	        f.setTitle("JTable Example");
	 
	        // Data to be displayed in the JTable
	        String[][] datos = new String [100][6] ;
	 
	        // Column Names
	        String[] columnNames = { "Movimiento", "Metodo", "Importe" , "Nota", "Usuario", "Categoria" };
	        f.getContentPane().setLayout(null);
	 
	        // Initializing the JTable
	        j = new JTable(datos, columnNames);
	        j.setBounds(30, 40, 200, 300);
	 
	        // adding it to JScrollPane
	        JScrollPane sp = new JScrollPane(j);
	        sp.setBounds(0, 34, 486, 91);
	        f.getContentPane().add(sp);
	                
	        // Frame Size
	        f.setSize(500, 200);
	        // Frame Visible = true
	        f.setVisible(true);
	        
	        //Botón Volver
	        BotonVolver = new Button("Volver");
	        BotonVolver.setBackground(new Color(255, 255, 255));
	        BotonVolver.addActionListener(this);      	
	        BotonVolver.setBounds(200, 131, 81, 22);
	        f.getContentPane().add(BotonVolver);
	               	        
	        //Filtrar
	        Filtrar = new JLabel("Filtrar: ");
	        Filtrar.setFont(new Font("Tahoma", Font.BOLD, 15));
	        Filtrar.setBounds(99, 12, 65, 14);
	        f.getContentPane().add(Filtrar);
	        
	        //Filtrar Valor
	        FiltrarValor = new JTextField();
	        FiltrarValor.setBounds(174, 11, 121, 15);
	        f.getContentPane().add(FiltrarValor);
	        FiltrarValor.setColumns(10);
	        
	        BuscarBoton = new JButton("Buscar");
	        BuscarBoton.addActionListener(this);
	        	
	        BuscarBoton.setBounds(315, 10, 81, 14);
	        f.getContentPane().add(BuscarBoton);
	        FiltrarValor.addActionListener(this);
	        
	        
	        try {
	    		ArrayList<Transaccion> ListaOperaciones = FuncionesOperaciones.Historial(usuario, conexion);
	    		for(int i=0;i<ListaOperaciones.size();i++) {
	    			datos[i][0] = ListaOperaciones.get(i).getMovimiento();
	    			datos[i][1] = ListaOperaciones.get(i).getMetodopago();
	    			datos[i][2] = ListaOperaciones.get(i).getImporte();
	    			datos[i][3] =ListaOperaciones.get(i).getNotas();
	    			datos[i][4] = ListaOperaciones.get(i).getUsuario();
	    			datos[i][5] = ListaOperaciones.get(i).getCategoria();

	    		}
	    	} catch (SQLException e1) {
	    		e1.printStackTrace();
	    	}
	    	
	        
	    }


	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BotonVolver) {
			this.setVisible(false);
			try {
				Principal2 p1 = new Principal2(usuario,operacion,conexion);
				p1.setVisible(true);
				

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			}
		
		
		if(e.getSource()==BuscarBoton) {
					
		try {
			String AñadirOperaciones = FuncionesOperaciones.Filtrar(usuario,conexion);
			System.out.println("hh");
			this.setName(AñadirOperaciones);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		}
	}
	
	
	
}
	


