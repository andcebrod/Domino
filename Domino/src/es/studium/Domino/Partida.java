package es.studium.Domino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Partida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPareja1;
	private JTextField txtPareja2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida frame = new Partida();
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
	public Partida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{424, 0};
		gbl_contentPane.rowHeights = new int[]{30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnl1 = new JPanel();
		GridBagConstraints gbc_pnl1 = new GridBagConstraints();
		gbc_pnl1.insets = new Insets(0, 0, 5, 0);
		gbc_pnl1.fill = GridBagConstraints.BOTH;
		gbc_pnl1.gridx = 0;
		gbc_pnl1.gridy = 0;
		contentPane.add(pnl1, gbc_pnl1);
		
		JLabel lblPartido = new JLabel("Partido:");
		pnl1.add(lblPartido);
		lblPartido.setFont(new Font("Calibri", Font.BOLD, 15));
		
		JLabel lblParejasPartido = new JLabel("xxxx VS yyyy");
		pnl1.add(lblParejasPartido);
		lblParejasPartido.setFont(new Font("Calibri", Font.BOLD, 15));
		
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(null);
		GridBagConstraints gbc_pnl2 = new GridBagConstraints();
		gbc_pnl2.fill = GridBagConstraints.BOTH;
		gbc_pnl2.gridx = 0;
		gbc_pnl2.gridy = 1;
		contentPane.add(pnl2, gbc_pnl2);
		
		JLabel lblEq = new JLabel("Pareja 1:");
		lblEq.setBounds(127, 51, 44, 14);
		pnl2.add(lblEq);
		
		txtPareja1 = new JTextField();
		txtPareja1.setBounds(209, 48, 86, 20);
		pnl2.add(txtPareja1);
		txtPareja1.setColumns(10);
		
		JLabel lblPareja = new JLabel("Pareja 2:");
		lblPareja.setBounds(127, 82, 44, 14);
		pnl2.add(lblPareja);
		
		txtPareja2 = new JTextField();
		txtPareja2.setBounds(209, 79, 86, 20);
		pnl2.add(txtPareja2);
		txtPareja2.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(106, 118, 89, 23);
		pnl2.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(206, 118, 89, 23);
		pnl2.add(btnCancelar);
		
		JLabel lblIntroduzcaLaPuntuacin = new JLabel("Introduzca la puntuaci\u00F3n de cada pareja:");
		lblIntroduzcaLaPuntuacin.setBounds(106, 11, 204, 14);
		pnl2.add(lblIntroduzcaLaPuntuacin);
		
		JButton btnNewButton = new JButton("Imprimir puntuaciones");
		btnNewButton.setBounds(127, 165, 155, 23);
		pnl2.add(btnNewButton);
	}
}
