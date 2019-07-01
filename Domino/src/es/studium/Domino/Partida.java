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

public class Partida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtPareja1;
	JTextField txtPareja2;
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

	
	public Partida(String nomPareja1, String nomPareja2, int pareja1, int pareja2, int campeonato, int jornada, int mesa) 
	{
		idPareja1 = pareja1;
		idPareja2 = pareja2;
		idCampeonato = campeonato;
		idJornada = jornada;
		Pareja1 = nomPareja1;
		Pareja2 = nomPareja2;
		int Mesa = mesa;
		
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
		lblEq.setBounds(78, 79, 44, 14);
		pnl2.add(lblEq);
		
		txtPareja1 = new JTextField();
		txtPareja1.setBounds(333, 76, 86, 20);
		pnl2.add(txtPareja1);
		txtPareja1.setColumns(10);
		
		JLabel lblPareja = new JLabel("Pareja 2:");
		lblPareja.setBounds(78, 110, 44, 14);
		pnl2.add(lblPareja);
		
		txtPareja2 = new JTextField();
		txtPareja2.setBounds(333, 107, 86, 20);
		pnl2.add(txtPareja2);
		txtPareja2.setColumns(10);
		
		btnAceptar.setBounds(147, 170, 89, 23);
		pnl2.add(btnAceptar);
		
		btnCancelar.setBounds(297, 170, 89, 23);
		pnl2.add(btnCancelar);
		
		JLabel lblIntroduzcaLaPuntuacin = new JLabel("Introduzca la puntuación de cada pareja:");
		lblIntroduzcaLaPuntuacin.setBounds(170, 22, 204, 14);
		pnl2.add(lblIntroduzcaLaPuntuacin);
		
		btnImprimirPunt.setBounds(191, 217, 155, 23);
		pnl2.add(btnImprimirPunt);
		this.setVisible(true);
	}
}
