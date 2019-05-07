package es.studium.Domino;

import java.awt.*;

import javax.swing.*;

public class MenuPrincipal extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblHacer = new JLabel("¿Que desea hacer?");
	JLabel lblNombre = new JLabel("Introduzca nombre del torneo");
	
	
	JButton btnNuevo = new JButton ("Nuevo Torneo");
	JButton btnContinuar = new JButton ("Continuar Torneo");
	JButton btnAyuda = new JButton ("Ayuda");
	JTextField txtNombre = new JTextField(20);
	JButton btnAceptar = new JButton("Aceptar");
	JButton btnCancelar = new JButton ("Cancelar");
	
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	
	JPanel pnl4 = new JPanel();
	JPanel pnl5 = new JPanel();
	JPanel pnl6 = new JPanel();
	
	JDialog dlgNombre = new JDialog(this, "Nombre del Torneo");
	
	public MenuPrincipal() {
		this.setSize(300,200);
		this.setLayout(new GridLayout(3,1));
		this.setLocationRelativeTo(null);
		this.setTitle("Torneos de Dominó");
		pnl1.add(lblHacer);
		pnl2.add(btnNuevo);
		pnl2.add(btnContinuar);
		pnl3.add(btnAyuda);
		this.add(pnl1);
		this.add(pnl2);
		this.add(pnl3);
		dlgNombre.setSize(300,200);
		dlgNombre.setLayout(new GridLayout(3,1));
		dlgNombre.setLocationRelativeTo(null);
		pnl4.add(lblNombre);
		pnl5.add(txtNombre);
		pnl6.add(btnAceptar);
		pnl6.add(btnCancelar);
		dlgNombre.add(pnl4);
		dlgNombre.add(pnl5);
		dlgNombre.add(pnl6);
		dlgNombre.setVisible(false);
		this.setVisible(true);
	}
}
