package es.studium.Domino;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultarClasificacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	JTable tablaParejas= new JTable(modeloTabla);
	JButton btnAceptar = new JButton("Aceptar");
	JButton btnImprimir = new JButton("Imprimir PDF");
	JPanel pnlB = new JPanel();

	public ConsultarClasificacion() 
	{
		this.setSize(980,400);
		this.setTitle("Clasificación");
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tablaParejas),BorderLayout.CENTER);
		pnlB.add(btnAceptar);
		pnlB.add(btnImprimir);
		this.add(pnlB,BorderLayout.SOUTH);
		this.setVisible(true);
		
		
	}

}
