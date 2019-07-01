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
	
	DefaultTableModel modeloTabla;
	JTable tablaParejas; 
	JButton btnJugarPartida;
	JPanel pnlB;
	
	
	public Torneo(String nombreTorneo, int idCamp) 
	{
		pnlB = new JPanel();
		modeloTabla = new DefaultTableModel();
		tablaParejas= new JTable(modeloTabla);
		idCampeonato = idCamp;
		btnJugarPartida = new JButton("Jugar Partida");
		
		this.setTitle("Torneo "+nombreTorneo);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setBounds(100, 100, 706, 418);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnJornadas = new JMenu("Jornadas");
		menuBar.add(mnJornadas);
		
		mniAvanzarJornada = new JMenuItem("Avanzar Jornada");
		mnJornadas.add(mniAvanzarJornada);
		
		mniConsJornada = new JMenuItem("Consultar Jornada");
		mnJornadas.add(mniConsJornada);
		
		mnNewMenu = new JMenu("Clasificaci�n");
		menuBar.add(mnNewMenu);
		
		mniConsClasificacion = new JMenuItem("Consultar Clasificaci�n");
		mnNewMenu.add(mniConsClasificacion);
		
		mnParejas = new JMenu("Parejas");
		menuBar.add(mnParejas);
		
		mniModificarPareja = new JMenuItem("Modificar Pareja");
		mnParejas.add(mniModificarPareja);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		
		this.add(new JScrollPane(tablaParejas),BorderLayout.CENTER);
		pnlB.add(btnJugarPartida);
		this.add(pnlB,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
}
