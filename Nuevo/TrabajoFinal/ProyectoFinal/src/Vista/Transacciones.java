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

public class Transacciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Historial;
	private JLabel lblNewLabel;
	private String usuario, operacion;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	private JTable table;
	
	
	public Transacciones(String usuario, String operacion, ConexionMySQL conexion) {
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
	        f.getContentPane().setBackground(new Color(0, 139, 139));
	 
	        // Frame Title
	        f.setTitle("JTable Example");
	 
	        // Data to be displayed in the JTable
	        String[][] datos = new String [50][6] ;
	 
	        // Column Names
	        String[] columnNames = { "Nombre", "Movimiento", "Metodo", "Importe", "Notas" , "Categoria" };
	        f.getContentPane().setLayout(null);
	 
	        // Initializing the JTable
	        j = new JTable(datos, columnNames);
	        j.setBounds(30, 40, 200, 300);
	 
	        // adding it to JScrollPane
	        JScrollPane sp = new JScrollPane(j);
	        sp.setBounds(0, 0, 486, 112);
	        f.getContentPane().add(sp);
	        
	        Button button = new Button("Volver");
	        button.addActionListener(this);
	        	
	        button.setBounds(390, 132, 75, 21);
	        f.getContentPane().add(button);
	        // Frame Size
	        f.setSize(500, 200);
	        // Frame Visible = true
	        f.setVisible(true);
	        
	        
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

		
	}
	
	
	
			
	

}
