package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.itextpdf.text.Document;

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
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja1.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja2.getText()+",puntosClasificacion=puntosClasificacion+3 WHERE idPareja ="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja2.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja1.getText()+" WHERE idPareja ="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDA("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Puntos añadidos correctamente.");
				Pt.setVisible(false);
			} else if(Integer.parseInt(Pt.txtPareja1.getText())<Integer.parseInt(Pt.txtPareja2.getText())) 
			{
				Mo.ejecutarIDASIN("INSERT INTO partidas (puntosLocal, puntosVisitante, idPareja1FK, idPareja2FK, idCampeonatoFK, idJornadaFK) VALUES ("+Pt.txtPareja1.getText()+","+Pt.txtPareja2.getText()+","+Pt.idPareja1+","+Pt.idPareja2+","+Pt.idCampeonato+","+Pt.idJornada+") ", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja1.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja2.getText()+" WHERE idPareja ="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja2.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja1.getText()+",puntosClasificacion=puntosClasificacion+3 WHERE idPareja ="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDA("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Puntos añadidos correctamente.");
				Pt.setVisible(false);
			} else if (Integer.parseInt(Pt.txtPareja1.getText())==Integer.parseInt(Pt.txtPareja2.getText())) 
			{
				Mo.ejecutarIDASIN("INSERT INTO partidas (puntosLocal, puntosVisitante, idPareja1FK, idPareja2FK, idCampeonatoFK, idJornadaFK) VALUES ("+Pt.txtPareja1.getText()+","+Pt.txtPareja2.getText()+","+Pt.idPareja1+","+Pt.idPareja2+","+Pt.idCampeonato+","+Pt.idJornada+") ", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja1.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja2.getText()+",puntosClasificacion=puntosClasificacion+1 WHERE idPareja ="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja1+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDASIN("UPDATE parejas SET puntosAFavor = puntosAFavor+"+Pt.txtPareja2.getText()+",puntosEnContra=puntosEnContra+"+Pt.txtPareja1.getText()+",puntosClasificacion=puntosClasificacion+1 WHERE idPareja ="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
				Mo.ejecutarIDA("UPDATE parejas SET diferencia = puntosAFavor-puntosEnContra where idPareja="+Pt.idPareja2+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Puntos añadidos correctamente.");
				Pt.setVisible(false);
			}
			
		} else if(Pt.btnImprimirPunt.equals(ae.getSource())) 
		{
			
			
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
		Pt.setVisible(false);
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
