package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesOperaciones;
import Repositorio.FuncionesRegistro;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

public class Registro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final JSeparator separator = new JSeparator();
	private JTextField userText; 
	private JButton botonregistro;
	private JPasswordField passwordText;
	private JLabel Usuario, Contraseña;
	private JFrame v_registro;
	private final JSeparator separator_1 = new JSeparator();
	


	public Registro() {
		Ventana();
		Componentes();
		

	}
	
	
	public void Ventana()
	{	
		v_registro = new JFrame();
		v_registro.setTitle("Registro");
		v_registro.setBackground(new Color(240, 240, 240));

		v_registro.setSize(388, 317);
		v_registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v_registro.setLocation(200,200);
		v_registro.setResizable(true);
		v_registro.setVisible(true);

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		v_registro.getContentPane().add(contentPane);
		
		}
	
	
	public void Componentes() {
		contentPane.setLayout(null);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(62, 13, 0, 2);
		contentPane.add(separator);
		separator.setBounds(0, 187, 436, 36);
		contentPane.add(separator);
		

		Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(30, 40, 107, 47);
		contentPane.add(Usuario);

		userText = new JTextField(20);
		userText.setToolTipText("");
		userText.setBackground(new Color(255, 255, 255));
		userText.setBounds(120, 56, 166, 19);
		contentPane.add(userText);
		
		Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Contraseña.setForeground(new Color(0, 0, 0));
		Contraseña.setBounds(30, 127, 81, 19);
		contentPane.add(Contraseña);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(120, 129, 166, 19);
		contentPane.add(passwordText);

			
		botonregistro = new JButton("Registrar");
		botonregistro.addActionListener(this);
		botonregistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonregistro.setBounds(149, 209, 93, 27);
		contentPane.add(botonregistro);
		
		

		
	
}


	public void actionPerformed(ActionEvent e) {
		
		  if(e.getSource()==botonregistro) {
			  v_registro.setVisible(false);
			  
			  String usuario = userText.getText(); 
	        String contraseña = passwordText.getText(); 
	        
	        ConexionMySQL conexion = new ConexionMySQL("proyectofinal", "proyectofinal", "proyectofinal");
			try {
				conexion.conectar();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
			
				int Registro = FuncionesRegistro.registro(usuario,contraseña,conexion);
				System.out.println("Registro: " +  Registro);
				
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Usuario Existente",
	  					"Fallo de registro", JOptionPane.ERROR_MESSAGE);}
			
			   userText.setText("");
			   passwordText.setText("");
			}
		
		
		
	
		 
	}
	
	
	

	}

