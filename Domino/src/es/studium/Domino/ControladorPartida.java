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
			Mo.ejecutarIDA("INSERT INTO partidas (puntosLocal, puntosVisitante, idPareja1FK, idPareja2FK, idCampeonatoFK, idJornadaFK) VALUES ("+Pt.txtPareja1+","+Pt.txtPareja2+","+Pt.idPareja1+","+Pt.idPareja2+","+Pt.idCampeonato+","+Pt.idJornada+") ", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Partida añadida correctamente.");
			
			
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
