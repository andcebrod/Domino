package es.studium.Domino;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class Partida extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnAceptar = new JButton("Aceptar");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnImprimirPunt = new JButton("Imprimir puntuaciones");
	
	int idPareja1;
	int idPareja2;
	int idCampeonato;
	int idJornada;
	String Pareja1;
	String Pareja2;
	int Mesa;
	JTextField txtPareja1;
	JTextField txtPareja2;

	
	public Partida(String nomPareja1, String nomPareja2, int pareja1, int pareja2, int campeonato, int jornada, int mesa) 
	{
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		idPareja1 = pareja1;
		idPareja2 = pareja2;
		idCampeonato = campeonato;
		idJornada = jornada;
		Pareja1 = nomPareja1;
		Pareja2 = nomPareja2;
		Mesa = mesa;
		
		this.setTitle("Partida");
		setBounds(100, 100, 573, 380);
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
		
		JLabel lblParejasPartido = new JLabel(nomPareja1+" CONTRA "+nomPareja2);
		pnl1.add(lblParejasPartido);
		lblParejasPartido.setFont(new Font("Calibri", Font.BOLD, 15));
		
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(null);
		GridBagConstraints gbc_pnl2 = new GridBagConstraints();
		gbc_pnl2.fill = GridBagConstraints.BOTH;
		gbc_pnl2.gridx = 0;
		gbc_pnl2.gridy = 1;
		contentPane.add(pnl2, gbc_pnl2);
		
		btnAceptar.setBounds(146, 212, 89, 23);
		pnl2.add(btnAceptar);
		
		btnCancelar.setBounds(302, 212, 89, 23);
		pnl2.add(btnCancelar);
		
		JLabel lblIntroduzcaLaPuntuacin = new JLabel("INTRODUZCA LA PUNTUACI\u00D3N DE CADA PAREJA:");
		lblIntroduzcaLaPuntuacin.setBounds(120, 11, 310, 14);
		pnl2.add(lblIntroduzcaLaPuntuacin);
		
		btnImprimirPunt.setBounds(191, 246, 155, 23);
		pnl2.add(btnImprimirPunt);
		
		JPanel panel = new JPanel();
		panel.setBounds(63, 48, 404, 146);
		pnl2.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel label = new JLabel("PAREJA 1: "+nomPareja1);
		panel_1.add(label);
		
		txtPareja1 = new JTextField();
		panel_1.add(txtPareja1);
		txtPareja1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("PAREJA 2: "+nomPareja2);
		panel_2.add(label_1);
		
		txtPareja2 = new JTextField();
		panel_2.add(txtPareja2);
		txtPareja2.setColumns(10);
		this.setVisible(true);
	}
}
