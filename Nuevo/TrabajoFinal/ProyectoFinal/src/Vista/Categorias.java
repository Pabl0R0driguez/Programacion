package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Categorias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Categorias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LELELE");
		lblNewLabel.setBounds(144, 90, 140, 70);
		contentPane.add(lblNewLabel);
	}
	
	 /* Configuración general de la ventana principal */
	 private void initPantalla() {
		 	setLocation(100,100);
	        setTitle("Ventana Principal"); //Título del JFrame
	        setSize(514, 291); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }

}
