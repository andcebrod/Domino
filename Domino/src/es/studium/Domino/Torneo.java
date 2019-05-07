package es.studium.Domino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Torneo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Torneo frame = new Torneo();
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
	public Torneo() {
		setTitle("Torneo \"Amigos del Domino\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 418);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJornadas = new JMenu("Jornadas");
		menuBar.add(mnJornadas);
		
		JMenuItem mniAvanzarJornada = new JMenuItem("Avanzar Jornada");
		mnJornadas.add(mniAvanzarJornada);
		
		JMenuItem mniConsJornada = new JMenuItem("Consultar Jornada");
		mnJornadas.add(mniConsJornada);
		
		JMenu mnNewMenu = new JMenu("Clasificación");
		menuBar.add(mnNewMenu);
		
		JMenuItem mniConsClasificacion = new JMenuItem("Consultar Clasificación");
		mnNewMenu.add(mniConsClasificacion);
		
		JMenuItem mniImprimirClas = new JMenuItem("Imprimir Clasificación");
		mnNewMenu.add(mniImprimirClas);
		
		JMenu mnParejas = new JMenu("Parejas");
		menuBar.add(mnParejas);
		
		JMenuItem mniModificarPareja = new JMenuItem("Modificar Pareja");
		mnParejas.add(mniModificarPareja);
		
		JMenuItem mniEliminarPareja = new JMenuItem("Eliminar Pareja");
		mnParejas.add(mniEliminarPareja);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{680, 0};
		gbl_contentPane.rowHeights = new int[]{37, 240, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnl1 = new JPanel();
		GridBagConstraints gbc_pnl1 = new GridBagConstraints();
		gbc_pnl1.fill = GridBagConstraints.BOTH;
		gbc_pnl1.insets = new Insets(0, 0, 5, 0);
		gbc_pnl1.gridx = 0;
		gbc_pnl1.gridy = 0;
		contentPane.add(pnl1, gbc_pnl1);
		
		JLabel lblJornada = new JLabel("Jornada");
		pnl1.add(lblJornada);
		lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
		lblJornada.setFont(new Font("Ebrima", Font.BOLD, 16));
		
		JLabel lblNumeroJornada = new JLabel("X");
		lblNumeroJornada.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroJornada.setFont(new Font("Ebrima", Font.BOLD, 16));
		pnl1.add(lblNumeroJornada);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Partida", "Partida"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		JButton btnJugar = new JButton("Jugar partida");
		panel.add(btnJugar);
		
		JButton btnFinalizarTorneo = new JButton("Finalizar Torneo");
		panel.add(btnFinalizarTorneo);
	}
}
