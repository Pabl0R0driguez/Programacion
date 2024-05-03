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
import Repositorio.FuncionesOperaciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Toolkit;

public class EliminarUsuario implements ActionListener {
	// Las creamos fuera para poder utilizarlas en todos los metodos
	JTextField NuevoUsuario;
	JPasswordField ContraseñaValor;
	JFrame v_iniciosesion;
	JButton Actualizar;
	JPanel contentPane;
	ConexionMySQL conexion;//Defino la variable conexión fuera del if para poder llamarla en toda la función

	
	public EliminarUsuario(ConexionMySQL conexion) {
		this.conexion=conexion;
		v_iniciosesion = new JFrame("Inicio de Sesión");
		v_iniciosesion.setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/Imagenes/hucha.png")));
		v_iniciosesion.setBackground(new Color(240, 240, 240));
		v_iniciosesion.setSize(388, 317);
		v_iniciosesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
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

		//Usuario
		JLabel Usuario = new JLabel("Nuevo Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(10, 42, 118, 25);
		panel.add(Usuario);

		//Usuario Valor
		NuevoUsuario = new JTextField(20);
		NuevoUsuario.setToolTipText("");
		NuevoUsuario.setBackground(new Color(255, 255, 255));
		NuevoUsuario.setBounds(114, 44, 160, 25);
		panel.add(NuevoUsuario);
		
		//Contaseña
		JLabel Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Contraseña.setForeground(new Color(0, 0, 0));
		Contraseña.setBounds(10, 116, 102, 25);
		panel.add(Contraseña);

		//Contraseña Valor
		ContraseñaValor = new JPasswordField(20);
		ContraseñaValor.setBounds(114, 116, 160, 25);
		panel.add(ContraseñaValor);
			
		//Botón Registro
		Actualizar = new JButton("Eliminar");
		Actualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Actualizar.setBounds(130, 202, 118, 52);
		panel.add(Actualizar);
		Actualizar.addActionListener(this);

	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==Actualizar) {
			
				
			
		String usuario = NuevoUsuario.getText();
		String contraseña = ContraseñaValor.getText();
		
		try {
			FuncionesOperaciones.Eliminar(usuario, conexion);;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		InicioSesion r1 = new InicioSesion();
		}

		
		}
	}

	
