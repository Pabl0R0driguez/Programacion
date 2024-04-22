package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

public class Efectivo extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu Opciones, Pago,Historial, Salir;
	private JMenuItem Tarjeta, Efectivo , SalirItem;
	private JPanel contentPane;
	private JLabel etiqueta_saldo;
	private JButton boton_ingreso,  boton_gastos;
	private JLabel label;
	private JLabel label_1;
	private JSeparator separator;
	

	public Efectivo() {
		Menu();
		Saldo();
	    initPantalla();

	}   

//////////MENU/////////

	
	public static void main(String[] args) {

		Principal2 p2= new Principal2();
		}
	public void Menu() {
		     		
		/* Creamos el JMenuBar y lo asociamos con el JFrame */
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		/* Creamos el primer JMenu y lo pasamos como parámetro al JMenuBar mediante el método add */
		Opciones=new JMenu("Opciones");
		menuBar.add(Opciones);
		
		/* Creamos el segundo y tercer objetos de la clase JMenu y los asociamos con el primer JMenu creado */
		Pago=new JMenu("Pago");
		Opciones.add(Pago);
		
		JMenu Historial = new JMenu("Historial");
		menuBar.add(Historial);
		
		JMenuItem Transacciones = new JMenuItem("Transacciones");
		Historial.add(Transacciones);
		
		/* Creamos los dos primeros objetos de la clase JMenuItem y los asociamos con el segundo JMenu */
		Tarjeta=new JMenuItem("Tarjeta");
		Pago.add(Tarjeta);
		
		Tarjeta.addActionListener(this);
		Efectivo=new JMenuItem("Efectivo");
		Pago.add(Efectivo);
		Efectivo.addActionListener(this);
		
		
		
		Salir=new JMenu("Salir");
		menuBar.add(Salir);
		
		SalirItem=new JMenuItem("Cerrar Sesión");
		Salir.add(SalirItem);
		SalirItem.addActionListener(this);
		getContentPane().setLayout(null);
		
		
		}
      	
      	
        public void Saldo() {
        	
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        etiqueta_saldo = new JLabel("Saldo:");
        etiqueta_saldo.setBounds(228, 11, 102, 48);
        getContentPane().add(etiqueta_saldo);
        
        label = new JLabel("");
        label.setBounds(284, 20, 0, 0);
        contentPane.add(label);
        
        label_1 = new JLabel("");
        label_1.setBounds(289, 20, 0, 0);
        contentPane.add(label_1);
        
        boton_ingreso = new JButton("Ingresos");
        boton_ingreso.setBounds(137, 92, 102, 50);
        getContentPane().add(boton_ingreso);
        boton_ingreso.addActionListener(this);
        
        
        boton_gastos = new JButton("Gastos");
        boton_gastos.setBounds(284, 92, 102, 50);
        getContentPane().add(boton_gastos);
        
        separator = new JSeparator();
        separator.setBounds(0, 49, 529, 10);
        contentPane.add(separator);
        boton_gastos.addActionListener(this);
       
        
        setVisible(false);

       }
        
		
		/* Configuración general de la ventana principal */
		 private void initPantalla() {
		        setTitle("Efectivo"); //Título del JFrame
		        setSize(514, 291); //Dimensiones del JFrame
		        setResizable(true); //Redimensionable
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
		        setVisible(true); //Mostrar JFrame
		    }
		 
		 

	    /* Método que implementa las acciones de cada ítem de menú */
	    public void actionPerformed(ActionEvent e) {
	    
	    	
	        if (e.getSource()==boton_ingreso) {
	        	Ingresos i1 = new Ingresos();
	        }
	        if (e.getSource()==boton_gastos) {
	        	Gastos g1 = new Gastos();
	        }
	       
	        if (e.getSource()==SalirItem) {
	           System.exit(0);
	        }
	        
	    
	        
	    }
	    
	  
}
