package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class Transacciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Transacciones() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	 private void initPantalla() {
		 	setLocation(200,200);
	        setTitle("Historial transacciones"); //Título del JFrame
	        setSize(514, 291); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }
	 
}
