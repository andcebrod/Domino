package es.studium.Domino;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Torneo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int idCampeonato;
	JMenuBar menuBar;
	JMenu mnJornadas;
	JMenu mnNewMenu;
	JMenu mnParejas;
	JMenu mnAyuda;
	
	JMenuItem mniAvanzarJornada;
	JMenuItem mniConsJornada;
	JMenuItem mniConsClasificacion;
	JMenuItem mniModificarPareja;
	JMenuItem mntmAyuda;
	
	MyOwnTableModel modeloTabla;
	JTable tablaParejas; 
	JButton btnJugarPartida;
	JPanel pnlB;
	
	String nombre;
	
	public Torneo(String nombreTorneo, int idCamp) 
	{
		nombre = nombreTorneo;
		pnlB = new JPanel();
		modeloTabla = new MyOwnTableModel();
		tablaParejas= new JTable(modeloTabla);
		tablaParejas.setShowVerticalLines(false);
		tablaParejas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		idCampeonato = idCamp;
		btnJugarPartida = new JButton("Jugar Partida");
		
		this.setTitle("Torneo "+nombreTorneo);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		this.setBounds(100, 100, 706, 418);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnJornadas = new JMenu("Jornadas");
		menuBar.add(mnJornadas);
		
		mniAvanzarJornada = new JMenuItem("Avanzar Jornada");
		mnJornadas.add(mniAvanzarJornada);
		
		mniConsJornada = new JMenuItem("Consultar Jornada");
		mnJornadas.add(mniConsJornada);
		
		mnNewMenu = new JMenu("Clasificación");
		menuBar.add(mnNewMenu);
		
		mniConsClasificacion = new JMenuItem("Consultar Clasificación");
		mnNewMenu.add(mniConsClasificacion);
		
		mnParejas = new JMenu("Parejas");
		menuBar.add(mnParejas);
		
		mniModificarPareja = new JMenuItem("Modificar Pareja");
		mnParejas.add(mniModificarPareja);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		
		getContentPane().add(new JScrollPane(tablaParejas),BorderLayout.CENTER);
		pnlB.add(btnJugarPartida);
		getContentPane().add(pnlB,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
}
