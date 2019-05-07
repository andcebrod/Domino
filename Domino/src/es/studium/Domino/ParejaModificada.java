package es.studium.Domino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ParejaModificada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParejaModificada frame = new ParejaModificada();
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
	public ParejaModificada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarPareja = new JLabel("Modificar Pareja:");
		lblModificarPareja.setBounds(161, 11, 106, 19);
		lblModificarPareja.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(lblModificarPareja);
		
		JLabel lblNewLabel = new JLabel("Jugador 1:");
		lblNewLabel.setBounds(46, 57, 70, 14);
		contentPane.add(lblNewLabel);
		
		txtJugador1 = new JTextField();
		txtJugador1.setBounds(126, 54, 254, 20);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(15);
		
		JLabel lblJugador = new JLabel("Jugador 2:");
		lblJugador.setBounds(46, 99, 70, 14);
		contentPane.add(lblJugador);
		
		txtJugador2 = new JTextField();
		txtJugador2.setColumns(15);
		txtJugador2.setBounds(126, 96, 254, 20);
		contentPane.add(txtJugador2);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(47, 137, 69, 14);
		contentPane.add(lblLocalidad);
		
		textField = new JTextField();
		textField.setColumns(15);
		textField.setBounds(126, 134, 254, 20);
		contentPane.add(textField);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(104, 185, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(241, 185, 89, 23);
		contentPane.add(btnCancelar);
	}
}
