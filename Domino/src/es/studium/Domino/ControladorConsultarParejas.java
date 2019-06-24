package es.studium.Domino;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

public class ControladorConsultarParejas implements ActionListener, WindowListener{
	ConsultarParejas Cc;
	Modelo Mo;
	Document documento = new Document();
	
	public ControladorConsultarParejas(ConsultarParejas cc, Modelo mo) 
	{
		this.Cc = cc;
		this.Mo = mo;
		Cc.btnAceptar.addActionListener(this);
		Cc.btnImprimir.addActionListener(this);
		Cc.modeloTabla.addColumn("Número de Pareja");
		Cc.modeloTabla.addColumn("Jugador 1");
		Cc.modeloTabla.addColumn("Jugador 2");
		Cc.modeloTabla.addColumn("Localidad");
		ResultSet Co = Mo.ejecutarSelect("select idPareja, jugador1, jugador2, localidad from parejas;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
		try {
			while (Co.next())
			{
				Object [] fila = new Object[4];
				for (int i=0;i<4;i++)
					fila[i] = Co.getObject(i+1); 
				Cc.modeloTabla.addRow(fila); 
			}
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		Mo.desconectar(Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(Cc.btnAceptar.equals(ae.getSource())) {
			Cc.setVisible(false);
		} else if(Cc.btnImprimir.equals(ae.getSource())) 
		{
		
			FileOutputStream ficheroPdf;
			try 
			{
				
				FileDialog fd = new FileDialog(Cc, "Seleccionar archivo", FileDialog.SAVE);
				fd.setFile("*.pdf");
				fd.setVisible(true);
				String filename = fd.getDirectory()+fd.getFile();
				ficheroPdf = new FileOutputStream(filename);
				PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
				documento.open();
				
				PdfPTable tabla = new PdfPTable(4);
				Paragraph titulo = new Paragraph("Parejas Torneo: ");
				Paragraph titulo2 = new Paragraph("    ");
				titulo.getFont().setStyle(Font.BOLD);
				titulo.getFont().setSize(20);
				titulo2.getFont().setStyle(Font.BOLD);
				titulo2.getFont().setSize(20);
				documento.add(titulo);
				documento.add(titulo2);
				Paragraph idCliente = new Paragraph("Nº Pareja");
				idCliente.getFont().setStyle(Font.BOLD);
				idCliente.getFont().setSize(15);
				tabla.addCell(idCliente);

				Paragraph nombreCliente = new Paragraph("Jugador 1");
				nombreCliente.getFont().setStyle(Font.BOLD);
				nombreCliente.getFont().setSize(15);
				tabla.addCell(nombreCliente);

				Paragraph direccionCliente = new Paragraph("Jugador 2");
				direccionCliente.getFont().setStyle(Font.BOLD);
				direccionCliente.getFont().setSize(15);
				tabla.addCell(direccionCliente);

				Paragraph telefono = new Paragraph("Localidad");
				telefono.getFont().setStyle(Font.BOLD);
				telefono.getFont().setSize(15);
				tabla.addCell(telefono);

				ResultSet Co = Mo.ejecutarSelect("select idPareja, jugador1, jugador2, localidad from parejas;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				try {
					while (Co.next())
					{
						for (int i=0;i<4;i++) {
							if(i==0) {
								tabla.addCell(Co.getString("idPareja")); 
							} else if(i==1) {
								tabla.addCell(Co.getString("jugador1"));
							} else if(i==2) {
								tabla.addCell(Co.getString("jugador2"));
							} else if(i==3) {
								tabla.addCell(Co.getString("localidad"));
							}
						}
					}
					documento.add(tabla);
					documento.close();
					JOptionPane.showMessageDialog(null,"Documento pdf creado correctamente.","Documento creado", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			} catch (DocumentException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e2.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		Cc.setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


}
