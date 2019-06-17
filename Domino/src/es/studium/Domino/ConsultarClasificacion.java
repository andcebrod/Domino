package es.studium.Domino;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultarClasificacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo = new DefaultTableModel();
	JTable tablaParejas= new JTable(modelo);
	JButton btnAceptar = new JButton("Aceptar");
	JPanel pnlB = new JPanel();

	public ConsultarClasificacion() 
	{
		this.setSize(500,200);
		this.setTitle("Consulta Ofertas");
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tablaParejas),BorderLayout.CENTER);
		pnlB.add(btnAceptar);
		this.add(pnlB,BorderLayout.SOUTH);
		this.setVisible(true);
		
		
	}

}
