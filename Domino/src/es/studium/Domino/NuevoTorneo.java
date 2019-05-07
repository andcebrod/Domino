package es.studium.Domino;

import java.awt.*;

import javax.swing.*;

public class NuevoTorneo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblNombre = new JLabel("");
	JButton btnAnadirPareja = new JButton("Añadir Pareja");
	JButton btnConsultarParejas = new JButton("Consultar Parejas");
	JButton btnEliminarPareja = new JButton("Eliminar Pareja");
	JButton btnComenzar = new JButton ("Comenzar Torneo");
	
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	
	public NuevoTorneo(String nombre) {
		lblNombre.setText(nombre);
		this.setSize(450,200);
		this.setLayout(new GridLayout(3,1));
		this.setLocationRelativeTo(null);
		this.setTitle("Nuevo Torneo");
		pnl1.add(lblNombre);
		pnl2.add(btnAnadirPareja);
		pnl2.add(btnConsultarParejas);
		pnl2.add(btnEliminarPareja);
		pnl3.add(btnComenzar);
		this.add(pnl1);
		this.add(pnl2);
		this.add(pnl3);
		
		
		this.setVisible(true);
		
	}
}
