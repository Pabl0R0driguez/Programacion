package Vista;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

import Repositorio.ConexionMySQL;
import java.awt.Toolkit;

public class Transacciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JLabel HistorialValor, Historial;
	private JLabel lblNewLabel;
	private String usuario, operacion;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	
	
	public Transacciones(String usuario, String operacion, ConexionMySQL conexion) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Transacciones.class.getResource("/Imagenes/hucha.png")));
		this.usuario=usuario;
		this.operacion=operacion;
		this.conexion=conexion;
		VentanaTransacciones();
		initPantalla();

	}
	
	public void VentanaTransacciones() {
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 33, 323, 238);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Historial Valor
		HistorialValor = new JLabel("");
		HistorialValor.setBounds(10, 11, 303, 216);
		panel.add(HistorialValor);
		
		//Historial
		Historial = new JLabel("Historial");
		Historial.setBounds(167, 11, 61, 11);
		contentPane.add(Historial);
		
		BotonIcono = new JLabel("");
		BotonIcono.setIcon(new ImageIcon(Transacciones.class.getResource("/Imagenes/atras.png")));
		BotonIcono.setBounds(343, 10, 45, 13);
		contentPane.add(BotonIcono);
		BotonIcono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
               Principal2 p1 = new Principal2(operacion, usuario, conexion);
            }
        });
		
	}
	
    private void initPantalla() {
		 	setLocation(200,200);
	        setTitle("Transacciones"); //Título del JFrame
	        setSize(402, 321); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }
    
    
    
    
}
