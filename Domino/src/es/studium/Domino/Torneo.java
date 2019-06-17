package es.studium.Domino;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Torneo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Torneo(String nombreTorneo) {
		setTitle("Torneo "+nombreTorneo);
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
		
	}
}
