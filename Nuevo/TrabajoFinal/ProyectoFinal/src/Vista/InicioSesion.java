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

public class InicioSesion implements ActionListener {
	// Las creamos fuera para poder utilizarlas en todos los metodos
	JTextField userText;
	JPasswordField passwordText;
	JFrame v_iniciosesion;
	JFrame v_ventanaprincipal;

	
	
	public InicioSesion() {

		// Creación de ventana de inicio de sesión
		JFrame frame = new JFrame("Inicio de Sesión");
		v_iniciosesion= frame;
		frame.setBackground(new Color(240, 240, 240));
		frame.getContentPane().setBackground(new Color(0, 64, 64));
		// Tamaño del marco de la ventana
		frame.setSize(361, 174);
		// .setDefaultCloseOperation--> Se utiliza para cerrar la ventana de trabajo
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(panel);
		ComponentesLogin(panel);

		frame.setVisible(true);
	}

	private void ComponentesLogin(JPanel panel) {

		panel.setLayout(null);

		JLabel Usuario = new JLabel("Usuario:");
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(10, 10, 80, 25);
		panel.add(Usuario);

		userText = new JTextField(20);
		userText.setToolTipText("");
		userText.setBackground(new Color(255, 255, 255));
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel Contraseña = new JLabel("Contraseña:");
		Contraseña.setBounds(10, 40, 80, 25);
		panel.add(Contraseña);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton botonlogin = new JButton("login");
		botonlogin.setBounds(182, 75, 80, 25);
		panel.add(botonlogin);

		JButton botonregistro = new JButton("registrar");
		botonregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonregistro.setBounds(88, 75, 80, 25);
		panel.add(botonregistro);

		// .addActionListener(this)--> Capturar futuros eventos sobre el boton : login
		botonlogin.addActionListener(this);

	}

	// actionPerformed --> Método que se ejecuta cuando se realiza algún evento
	// sobre el botón
	@Override
	public void actionPerformed(ActionEvent e) {
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
					Principal2 vp = new Principal2();

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