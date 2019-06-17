package es.studium.Domino;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPareja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtJugador1;
	JTextField txtJugador2;
	JTextField txtLocalidad;
	
	JButton btnAnadir = new JButton("Añadir");
	JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Create the frame.
	 */
	public AddPareja() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirPareja = new JLabel("Añadir Pareja:");
		lblAadirPareja.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAadirPareja.setBounds(164, 28, 106, 19);
		contentPane.add(lblAadirPareja);
		
		JLabel label_1 = new JLabel("Jugador 1:");
		label_1.setBounds(42, 73, 70, 14);
		contentPane.add(label_1);
		
		txtJugador1 = new JTextField();
		txtJugador1.setColumns(15);
		txtJugador1.setBounds(122, 70, 254, 20);
		contentPane.add(txtJugador1);
		
		txtJugador2 = new JTextField();
		txtJugador2.setColumns(15);
		txtJugador2.setBounds(122, 112, 254, 20);
		contentPane.add(txtJugador2);
		
		JLabel label_2 = new JLabel("Jugador 2:");
		label_2.setBounds(42, 115, 70, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Localidad:");
		label_3.setBounds(43, 153, 69, 14);
		contentPane.add(label_3);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(15);
		txtLocalidad.setBounds(122, 150, 254, 20);
		contentPane.add(txtLocalidad);
		

		btnAnadir.setBounds(100, 201, 89, 23);
		contentPane.add(btnAnadir);
		
	
		btnCancelar.setBounds(237, 201, 89, 23);
		contentPane.add(btnCancelar);
		this.setVisible(true);
	}
}
