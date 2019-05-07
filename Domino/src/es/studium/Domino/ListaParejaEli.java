package es.studium.Domino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class ListaParejaEli extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaParejaMod frame = new ListaParejaMod();
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
	public ListaParejaEli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneParejaA = new JLabel("Seleccione Pareja a eliminar:");
		lblSeleccioneParejaA.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSeleccioneParejaA.setBounds(87, 25, 245, 14);
		lblSeleccioneParejaA.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSeleccioneParejaA);
		
		Choice choice = new Choice();
		choice.setBounds(200, 87, 28, 20);
		contentPane.add(choice);
		
		JButton btnModificar = new JButton("Eliminar Pareja");
		btnModificar.setBounds(93, 175, 109, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 175, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCancelar);
	}

}
