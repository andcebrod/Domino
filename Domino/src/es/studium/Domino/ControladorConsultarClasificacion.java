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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;

public class ControladorConsultarClasificacion implements ActionListener, WindowListener{
	ConsultarClasificacion Cc;
	Modelo Mo;
	Document documento = new Document(PageSize.A4.rotate());
	
	public ControladorConsultarClasificacion(ConsultarClasificacion cc, Modelo mo) 
	{
		this.Cc = cc;
		this.Mo = mo;
		Cc.btnAceptar.addActionListener(this);
		Cc.btnImprimir.addActionListener(this);
		Cc.modeloTabla.addColumn("Posición");
		Cc.modeloTabla.addColumn("Número de Pareja");
		Cc.modeloTabla.addColumn("Jugador 1");
		Cc.modeloTabla.addColumn("Jugador 2");
		Cc.modeloTabla.addColumn("Puntos Clasificación");
		Cc.modeloTabla.addColumn("Puntos a Favor");
		Cc.modeloTabla.addColumn("Puntos en Contra");
		Cc.modeloTabla.addColumn("Diferencia");
		ResultSet Co = Mo.ejecutarSelect("select posicion,idPareja, jugador1, jugador2,puntosClasificacion, puntosAFavor, puntosEnContra, diferencia from parejas order by posicion asc, puntosClasificacion desc, diferencia desc, puntosAFavor desc;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
		try {
			while (Co.next())
			{
				Object [] fila = new Object[8];
				for (int i=0;i<8;i++)
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
				
				PdfPTable tabla = new PdfPTable(8);
				Paragraph titulo = new Paragraph("CLASIFICACIÓN: ");
				Paragraph titulo2 = new Paragraph("    ");
				titulo.getFont().setStyle(Font.BOLD);
				titulo.getFont().setSize(20);
				titulo2.getFont().setStyle(Font.BOLD);
				titulo2.getFont().setSize(20);
				documento.add(titulo);
				documento.add(titulo2);
				Paragraph posicion = new Paragraph("Posición");
				posicion.getFont().setStyle(Font.BOLD);
				tabla.addCell(posicion);

				Paragraph numpareja = new Paragraph("Nº Pareja");
				numpareja.getFont().setStyle(Font.BOLD);
				tabla.addCell(numpareja);

				Paragraph jugador1 = new Paragraph("Jugador 1");
				jugador1.getFont().setStyle(Font.BOLD);
				tabla.addCell(jugador1);

				Paragraph jugador2 = new Paragraph("Jugador 2");
				jugador2.getFont().setStyle(Font.BOLD);
				tabla.addCell(jugador2);

				Paragraph puntosClas = new Paragraph("Puntos Clasificación");
				puntosClas.getFont().setStyle(Font.BOLD);
				tabla.addCell(puntosClas);
				
				Paragraph puntosAFavor = new Paragraph("Puntos a Favor");
				puntosAFavor.getFont().setStyle(Font.BOLD);
				tabla.addCell(puntosAFavor);
				
				Paragraph puntosEnContra = new Paragraph("Puntos en Contra");
				puntosEnContra.getFont().setStyle(Font.BOLD);
				tabla.addCell(puntosEnContra);
				
				Paragraph diferencia = new Paragraph("Diferencia");
				diferencia.getFont().setStyle(Font.BOLD);
				tabla.addCell(diferencia);
				
				

				ResultSet Co = Mo.ejecutarSelect("select posicion,idPareja, jugador1, jugador2, puntosClasificacion, puntosAFavor, puntosEnContra, diferencia from parejas order by posicion asc, puntosClasificacion desc, diferencia desc, puntosAFavor desc;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				try {
					while (Co.next())
					{
						for (int i=0;i<8;i++) {
							if(i==0) {
								Paragraph numPos = new Paragraph(Co.getString("posicion"));
								numPos.getFont().setStyle(Font.BOLD);
								tabla.addCell(numPos); 
							}
							else if(i==1) {
								tabla.addCell(Co.getString("idPareja"));
							}
							else if(i==2) {
								tabla.addCell(Co.getString("jugador1"));
							} 
							else if(i==3) {
								tabla.addCell(Co.getString("jugador2"));
							}
							else if(i==4) {
								tabla.addCell(Co.getString("puntosClasificacion"));
							}
							else if(i==5) {
								tabla.addCell(Co.getString("puntosAFavor"));
							}
							else if(i==6) {
								tabla.addCell(Co.getString("puntosEnContra"));
							}
							else if(i==7) {
								tabla.addCell(Co.getString("diferencia"));
							}
						}
					}
					documento.add(tabla);
					documento.setPageSize(PageSize.A4);
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
