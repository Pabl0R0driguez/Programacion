package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.ConexionMySQL;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Principal2 extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu Historial, Salir;
	private JPanel contentPane;
	private JSeparator separator;
	private JMenu Categorias;
	private JMenuItem SalirItem,OpcionAñadir, Transacciones;
	private JLabel saldo;
	private JLabel cantidad;
	private JMenuItem OpcionVer;
	private JButton ingreso, gasto;
	private String usuario;//Guarda el nombre del usuario que ha iniciado sesión
	private ConexionMySQL conexion;

	public Principal2(String usuario, ConexionMySQL conexion) {
		this.usuario = usuario;
		this.conexion=conexion;
		Menu();
		Saldo();
	    initPantalla();
	    

	}   

//////////MENU/////////

	
	
	public void Menu() {
		     		
		/* Creamos el JMenuBar y lo asociamos con el JFrame */
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		Categorias = new JMenu("Categorias");
		menuBar.add(Categorias);
		
		OpcionVer = new JMenuItem("Ver");
		Categorias.add(OpcionVer);
        OpcionVer.addActionListener(this);

		
		OpcionAñadir = new JMenuItem("Añadir");
		Categorias.add(OpcionAñadir);
        OpcionAñadir.addActionListener(this);

		
		Historial = new JMenu("Historial");
		menuBar.add(Historial);
		
		
		Transacciones = new JMenuItem("Transacciones");
		Historial.add(Transacciones);
		Transacciones.addActionListener(this);
		
		
		
		
		Salir=new JMenu("Salir");
		menuBar.add(Salir);
		
		SalirItem=new JMenuItem("Cerrar Sesión");
		Salir.add(SalirItem);
		SalirItem.addActionListener(this);
		getContentPane().setLayout(null);
		
		
		}
      	
      	
        public void Saldo() {
        	
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        separator = new JSeparator();
        separator.setBounds(0, 62, 529, 10);
        contentPane.add(separator);
        
        //botón ingreso
        ingreso = new JButton("Ingreso");
        ingreso.setFont(new Font("Tahoma", Font.BOLD, 18));
        ingreso.addActionListener(this);
        ingreso.setBackground(new Color(255, 0, 0));
        ingreso.setBounds(47, 135, 111, 56);
        contentPane.add(ingreso);
        ingreso.setBackground(Color.GREEN);
        ingreso.setForeground(new Color(0, 0, 0));
        
        //botón gasto
        gasto = new JButton("Gasto");
        gasto.setFont(new Font("Tahoma", Font.BOLD, 18));
        gasto.addActionListener(this);
        		
        		
        
        gasto.setBackground(new Color(128, 0, 0));
        gasto.setBounds(225, 135, 111, 56);
        contentPane.add(gasto);
        gasto.setBackground(Color.RED);
        gasto.setForeground(new Color(0, 0, 0));
        
        cantidad = new JLabel("_____ €");
        cantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));

        cantidad.setHorizontalAlignment(SwingConstants.CENTER);
        cantidad.setBounds(208, 21, 68, 42);
        contentPane.add(cantidad);
        
        saldo = new JLabel("SALDO:");
        saldo.setBounds(101, 21, 97, 42);
        contentPane.add(saldo);
        saldo.setForeground(new Color(0, 0, 0));
        saldo.setHorizontalAlignment(SwingConstants.CENTER);
        saldo.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        

       }
        
		
		/* Configuración general de la ventana principal */
        private void initPantalla() {
		 	setLocation(200,200);
	        setTitle("Ventana Principal"); //Título del JFrame
	        setSize(402, 321); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }
		 
		 

	    /* Método que implementa las acciones de cada ítem de menú */
	    public void actionPerformed(ActionEvent e) {
	        
	       
	        if (e.getSource()==SalirItem) {
		           System.exit(0);
		           System.out.println("Sesión cerrada");
		        }
	        
	        if (e.getSource()==OpcionAñadir) {
	        	Categorias ca1 = new Categorias();
	        	ca1.setVisible(true);
		        }
	        
	        if (e.getSource()==OpcionVer) {
	        	Categorias ca1 = new Categorias();
	        	ca1.setVisible(true);
		        }
	        
	        if (e.getSource()==ingreso) {
	        	Operaciones i1;
				try {
					i1 = new Operaciones("Ingreso" , usuario, conexion);
					i1.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	  	    	
		        }
	        
	        if (e.getSource()==gasto) {
	        	Operaciones i1;
				try {
					i1 = new Operaciones("Gasto" , usuario,conexion);
					i1.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		    
		        }
	        
	        if(e.getSource()==Transacciones) {
	        	Transacciones t1 = new Transacciones();
	        	t1.setVisible(true);
	        }
	        
	        
	      
	    }
	    }

