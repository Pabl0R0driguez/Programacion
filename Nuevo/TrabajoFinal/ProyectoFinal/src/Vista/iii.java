package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class iii extends JFrame {
	public iii() {
		
		JComboBox comboBox_1 = new JComboBox();
		getContentPane().add(comboBox_1, BorderLayout.NORTH);
	}

	JComboBox<String> comboBox;

    public void Ingresos2() {
        setTitle("Menú Desplegable");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4"};

        JComboBox comboBox = new JComboBox<>(opciones);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                System.out.println("Opción seleccionada: " + seleccion);
            }
        });

        getContentPane().add(comboBox);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new iii();
            }
        });
}
}