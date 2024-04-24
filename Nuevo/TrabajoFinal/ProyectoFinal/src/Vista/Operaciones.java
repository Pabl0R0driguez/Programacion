package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Repositorio.ConexionMySQL;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;


import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class Operaciones extends JFrame implements ActionListener, ItemListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu Historial, Salir;
	private JMenuItem  SalirItem , Transacciones;
	private JButton Aceptar;
	private JLabel Categorias;
	private JComboBox <String> CategoriasValor;
	private JLabel Metodo;
	private JLabel Saldo;
	private JLabel Importe;
	private JTextField ImporteValor;
	private ButtonGroup grupo;
	private JRadioButton TarjetaBoton, EfectivoBoton;
	String operacion;
	private JTextField NotaValor;
	private JLabel Nota;
	private JSeparator separador;
	private JLabel Foto;
	
	public Operaciones(String operacion) {
		this.operacion=operacion;
		
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(0, 128, 128));
		Menu();
		initPantalla();
		Desplegable();
	}
	
	
	public void Menu() {
 		
		//Barra de consultas
		
		separador = new JSeparator();
		separador.setBounds(0, 188, 514, 9);
		getContentPane().add(separador);
		
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
				
		Historial = new JMenu("Historial");
		menuBar.add(Historial);
		
		Transacciones = new JMenuItem("Transacciones");
		Historial.add(Transacciones);
		
		Salir=new JMenu("Salir");
		menuBar.add(Salir);
		
		SalirItem=new JMenuItem("Cerrar Sesión");
		Salir.add(SalirItem);
		SalirItem.addActionListener(this);
		getContentPane().setLayout(null);
		
	
		
		Aceptar = new JButton("Aceptar");
		Aceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		Aceptar.addActionListener(this);
		 
		Aceptar.setBackground(new Color(255, 255, 255));
		Aceptar.setForeground(new Color(0, 0, 0));
		Aceptar.setBounds(364, 202, 110, 20);
		getContentPane().add(Aceptar);
		
		Categorias = new JLabel("Categorias:");
		Categorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Categorias.setBounds(10, 94, 90, 36);
		getContentPane().add(Categorias);
	}
	
		 public void Desplegable() {
		        getContentPane().setLayout(null);
		        CategoriasValor=new JComboBox<String>();
		        CategoriasValor.setBounds(91,104,100,20);

		        getContentPane().add(CategoriasValor);
		        
		        Metodo = new JLabel("Método: ");
		        Metodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        Metodo.setBounds(10, 57, 90, 36);
		        getContentPane().add(Metodo);
		        
		        Saldo = new JLabel("SALDO: ");
		        Saldo.setFont(new Font("Tahoma", Font.BOLD, 24));
		        Saldo.setHorizontalAlignment(SwingConstants.CENTER);
		        Saldo.setBounds(233, 62, 110, 68);
		        getContentPane().add(Saldo);
		        
		        Importe = new JLabel("Importe:");
		        Importe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        Importe.setBounds(10, 20, 60, 20);
		        getContentPane().add(Importe);
		        
		        ImporteValor = new JTextField();
		        ImporteValor.setBounds(91, 20, 100, 19);
		        getContentPane().add(ImporteValor);
		        ImporteValor.setColumns(10);
		        
		        NotaValor = new JTextField();
		        NotaValor.setBounds(91, 140, 100, 19);
		        getContentPane().add(NotaValor);
		        NotaValor.setColumns(10);
		        
		        TarjetaBoton = new JRadioButton("Tarjeta");
		        EfectivoBoton = new JRadioButton("Efectivo");

		        //Group the radio buttons.
		        ButtonGroup grupo = new ButtonGroup();
		        grupo.add(TarjetaBoton);
		        grupo.add(EfectivoBoton);
		        
				//Menu desplegable
		       // getContentPane().add(grupo);
	  		       	        
		        
		        Nota = new JLabel("Nota: ");
		        Nota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        Nota.setBounds(20, 142, 45, 13);
		        getContentPane().add(Nota);
		        
		        JPanel panel = new JPanel();
		        panel.setBackground(new Color(255, 255, 255));
		        panel.setBounds(91, 47, 100, 46);
		        getContentPane().add(panel);
		        panel.setLayout(null);
		        
		        JCheckBox Tarjeta = new JCheckBox("Tarjeta");
		        Tarjeta.setBounds(0, 0, 97, 23);
		        panel.add(Tarjeta);
		        
		        JCheckBox Efectivo = new JCheckBox("Efectivo");
		        Efectivo.setBounds(0, 23, 97, 23);
		        panel.add(Efectivo);
		        
		        //
		        JButton boton3 = new JButton("");
		        boton3.setBorderPainted(false);
		        boton3.setContentAreaFilled(false);
		        boton3.setBounds(118, 168, 173, 67);
		        boton3.addActionListener(this);
		        	
		        boton3.setBounds(333, 20, 89, 23);
		        getContentPane().add(boton3);
		        
		    
				ImageIcon icono2=new ImageIcon(Operaciones.class.getResource("Imagenes/ahorrar-dinero(1).png"));
				Image imagen2 = icono2.getImage().getScaledInstance(boton3.getWidth(),
				boton3.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
				boton3.setIcon(iconoAjustado2);
		        
		      

		        CategoriasValor.addItem("Ocio");
		        CategoriasValor.addItem("Casa");
		        CategoriasValor.addItem("Coche");
		        CategoriasValor.addItem("Salario");
		        CategoriasValor.addItem("Mascota");
		        CategoriasValor.addItem("Regalos");
		        CategoriasValor.addItem("Añadir");
		        

		        CategoriasValor.addItemListener(this);

		    }
		 
		 
		 
		 
	        		
	

		 //Metodo para que interactuen los items del menu desplegable
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getSource()==CategoriasValor ) {
		            String seleccionado=(String)CategoriasValor.getSelectedItem();
		            
		            switch (seleccionado) {
		              case "Añadir":
		                  Categorias a1 = new Categorias();
		                  a1.setVisible(true);
		                  break;
		          }		            
		        }	       
		    }
	
		    //Fotos-Iconos ///Pendiente
	       
		   
			
		
		//ActionPerformed
	  public void actionPerformed(ActionEvent e) {		    
		 
	        if (e.getSource()==SalirItem) {
	        	 System.exit(0);
	        }
	        
	        if (e.getSource()==boton3) {
	        	Principal2 p1 = new Principal2();
	    		p1.setVisible(true);
	        }
	        contentPane.add(boton3);
	    	
	        
	        if (e.getSource()==	Transacciones) {
	        	Categorias ca1 = new Categorias();
	        	setVisible(true);
	        }
	        if (e.getSource()==	Aceptar) {
	        	// 1.- Recoge los datos de la operación 
	        	
	        	String importe = ImporteValor.getText(); //Recogemos el importe introducido en el JTextField y lo guardamos en una variable temporal
	        	String metodo = "Tarjeta";  // Pte leer de la interface gráfica
	        	String categoria = "Ocio";   // mismo comentario
	        	String nota = NotaValor.getText();
	        	String operacion = this.operacion;
	        	String usuario = "usuario1";
	        	
	        	
	        	// 2.- Establece conexión con la base de datos
	        	ConexionMySQL conexion = new ConexionMySQL("proyectofinal", "proyectofinal", "ProyectoFinal");
	    		try {
	    			conexion.conectar();
	    		} catch (SQLException e1) {
	    			e1.printStackTrace();
	    		}

	        	// 3.- Insercción de operación
	        	
	        	// 4.- Vuelta a la ventana principal
	    		if (e.getSource()==	Aceptar) {
		        	Principal2 pp1 = new Principal2();
		        	pp1.setVisible(true);
		        	
		        	
		        	;
		        }
	    	
	        }	  
	  	}
	  
	  @Override
		public void stateChanged(ChangeEvent e) {
			
		}
	  
	  /* Configuración general de la ventana principal */
		 private void initPantalla() {
			 	setLocation(100,100);
		        setTitle(operacion); //Título del JFrame
		        setSize(514, 291); //Dimensiones del JFrame
		        setResizable(true); //Redimensionable
		        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerrar proceso al cerrar ventana
		        setVisible(true); //Mostrar JFrame
		    }
}
