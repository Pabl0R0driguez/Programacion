package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesInicioSesion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JSeparator;
import java.awt.Font;

public class InicioSesion implements ActionListener {
	// Las creamos fuera para poder utilizarlas en todos los metodos
	JTextField userText;
	JPasswordField passwordText;
	JFrame v_iniciosesion;
	JButton botonregistro, botonlogin;
	JPanel contentPane;

	
	
	public InicioSesion() {

		v_iniciosesion = new JFrame("Inicio de Sesión");
		v_iniciosesion.setBackground(new Color(240, 240, 240));
		v_iniciosesion.setSize(388, 317);
		v_iniciosesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		v_iniciosesion.getContentPane().add(contentPane);
		ComponentesLogin(contentPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 186, 374, 2);
		contentPane.add(separator);

		v_iniciosesion.setVisible(true);
	}

	private void ComponentesLogin(JPanel panel) {

		panel.setLayout(null);

		JLabel Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(24, 42, 80, 25);
		panel.add(Usuario);

		userText = new JTextField(20);
		userText.setToolTipText("");
		userText.setBackground(new Color(255, 255, 255));
		userText.setBounds(114, 44, 160, 25);
		panel.add(userText);

		JLabel Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Contraseña.setForeground(new Color(0, 0, 0));
		Contraseña.setBounds(10, 116, 102, 25);
		panel.add(Contraseña);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(114, 116, 160, 25);
		panel.add(passwordText);

		botonlogin = new JButton("Inicio Sesión");
		botonlogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonlogin.setBounds(190, 206, 130, 52);
		panel.add(botonlogin);
		botonlogin.addActionListener(this);
		
		botonregistro = new JButton("Registrar");
		botonregistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonregistro.setBounds(52, 206, 118, 52);
		panel.add(botonregistro);
		botonregistro.addActionListener(this);

	}
		

	
	// actionPerformed --> Método que se ejecuta cuando se realiza algún evento
	// sobre el botón
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==botonregistro) {
		Registro r1 = new Registro();
		r1.setVisible(true);
	}
	else {
		
		// 1.- Recoge el nombre de usuario y contraseña de la interfaz
	
		String usuario = userText.getText();
		String contraseña = passwordText.getText();// Pendiente

		System.out.println("Controlador: " + "Usuario: " + usuario + " " + "Contraseña: " + contraseña);

		// 2.- Establece conexión con la base de datos
		ConexionMySQL conexion = new ConexionMySQL("proyectofinal", "proyectofinal", "proyectofinal");
		try {
			conexion.conectar();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 3.-consulta a la base de datos, para comprobar el usuario y la contraseña

		try {
			boolean existeusuario = FuncionesInicioSesion.login(usuario, contraseña, conexion);

			
			if(existeusuario) 
				{
					System.out.println("Controlador: El usuario existe"); 
					// al iniciar correctamente la sesión, debe desaparecer la ventana de inicio de sesión.
					v_iniciosesion.setVisible(false);
					Principal2 vp = new Principal2(usuario, conexion);

				} 
				else 
				{
					System.out.println("Controlador: El usuario no existe"); 
			  		JOptionPane.showMessageDialog(null, "El usuario no existe, inténtalo de nuevo",
  					"Fallo de autenticación", JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
	}
}