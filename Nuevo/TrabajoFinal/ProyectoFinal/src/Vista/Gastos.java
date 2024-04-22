package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Gastos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu Historial, Salir;
	private JMenuItem Tarjeta, Efectivo ,Transacciones, SalirItem;
	
	
	public Gastos() {
		getContentPane().setBackground(new Color(0, 128, 192));
		Menu();
	}
	
	public void Menu() {
 		
		//Barra de consultas
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
		SalirItem.addActionListener((ActionListener) this);
		getContentPane().setLayout(null);
		
		
		//Etiquetas
		JLabel lblNewLabel = new JLabel("Nota: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(25, 128, 97, 23);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 162, 461, 9);
		getContentPane().add(separator);
		
		
		}
	
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource()==SalirItem) {
        	 System.exit(0);
        }
	        	
	        }
	 
	 /* Configuración general */
	 private void initPantalla() {
	        setTitle("Gastos"); //Título del JFrame
	        setSize(514, 291); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }
	 }

