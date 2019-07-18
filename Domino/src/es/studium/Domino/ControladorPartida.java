package es.studium.Domino;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ControladorPartida implements WindowListener, ActionListener 
{
	Partida Pt;
	Modelo Mo;
	Document documento = new Document();

	public ControladorPartida(Partida pt, Modelo mo) {
		this.Pt = pt;
		this.Mo = mo;
		Pt.btnAceptar.addActionListener(this);
		Pt.btnCancelar.addActionListener(this);
		Pt.btnImprimirPunt.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		if(Pt.btnAceptar.equals(ae.getSource())) 
		{
			if(Integer.parseInt(Pt.txtPareja1.getText())>Integer.parseInt(Pt.txtPareja2.getText())) 
			{
				Mo.ejecutarIDASIN("INSERT INTO partidas (puntosLocal, puntosVisitante, idPareja1FK, idPareja2FK, idCampeonatoFK, idJornadaFK) VALUES ("+Pt.txtPareja1.getText()+","+Pt.txtPareja2.getText()+","+Pt.idPareja1+","+Pt.idPareja2+","+Pt.idCampeonato+","+Pt.idJornada+") ", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja1.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja2.getText()+",puntosClasificacion=puntosClasificacion+1 WHERE idPareja ="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja2.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja1.getText()+" WHERE idPareja ="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDA("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Puntos añadidos correctamente.");
				Pt.setVisible(false);
			} else if(Integer.parseInt(Pt.txtPareja1.getText())<Integer.parseInt(Pt.txtPareja2.getText())) 
			{
				Mo.ejecutarIDASIN("INSERT INTO partidas (puntosLocal, puntosVisitante, idPareja1FK, idPareja2FK, idCampeonatoFK, idJornadaFK, mesa) VALUES ("+Pt.txtPareja1.getText()+","+Pt.txtPareja2.getText()+","+Pt.idPareja1+","+Pt.idPareja2+","+Pt.idCampeonato+","+Pt.idJornada+", "+Pt.Mesa+"); ", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja1.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja2.getText()+" WHERE idPareja ="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja2.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja1.getText()+",puntosClasificacion=puntosClasificacion+1 WHERE idPareja ="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDA("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Puntos añadidos correctamente.");
				Pt.setVisible(false);
			} else if (Integer.parseInt(Pt.txtPareja1.getText())==Integer.parseInt(Pt.txtPareja2.getText())) 
			{
				JOptionPane.showMessageDialog(null,"COMPRUEBE QUE LA PUNTUACIÓN ESTÉ CORRECTA","Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if(Pt.btnImprimirPunt.equals(ae.getSource())) 
		{
			FileOutputStream ficheroPdf;
			try 
			{

				FileDialog fd = new FileDialog(Pt, "Guardar archivo", FileDialog.SAVE);
				fd.setFile("Partida "+Pt.Pareja1+" Contra "+Pt.Pareja2+" Jornada "+Pt.idJornada+".pdf");
				fd.setVisible(true);
				String filename = fd.getDirectory()+fd.getFile();
				ficheroPdf = new FileOutputStream(filename);
				PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
				documento.open();

				PdfPTable tabla = new PdfPTable(2);
				Paragraph titulo = new Paragraph("Partida:");
				Paragraph titulo2 = new Paragraph("    ");
				titulo.getFont().setStyle(Font.BOLD);
				titulo.getFont().setSize(20);
				titulo2.getFont().setStyle(Font.BOLD);
				titulo2.getFont().setSize(20);
				documento.add(titulo);
				documento.add(titulo2);


				Paragraph mesa = new Paragraph("Mesa: "+Pt.Mesa);
				mesa.getFont().setStyle(Font.BOLD);
				mesa.getFont().setSize(15);
				tabla.addCell(mesa);

				Paragraph jornada = new Paragraph("Jornada: "+Pt.idJornada);
				jornada.getFont().setStyle(Font.BOLD);
				jornada.getFont().setSize(15);
				tabla.addCell(jornada);

				Paragraph pareja1 = new Paragraph("Pareja 1: "+Pt.Pareja1);
				pareja1.getFont().setStyle(Font.BOLD);
				pareja1.getFont().setSize(15);
				tabla.addCell(pareja1);

				Paragraph pareja2 = new Paragraph("Pareja 1: "+Pt.Pareja2);
				pareja2.getFont().setStyle(Font.BOLD);
				pareja2.getFont().setSize(15);
				tabla.addCell(pareja2);
				documento.setPageSize(PageSize.A4);
				documento.add(tabla);
				documento.close();
				JOptionPane.showMessageDialog(null,"Documento pdf creado correctamente.","Documento creado", JOptionPane.INFORMATION_MESSAGE);
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			} catch (DocumentException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e2.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			}


		} else if(Pt.btnCancelar.equals(ae.getSource())) 
		{
			Pt.setVisible(false);
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
	public void windowClosing(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub

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
