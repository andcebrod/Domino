package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorNuevoTorneo implements ActionListener, WindowListener
{
	Modelo Mo;
	NuevoTorneo Nt;
	AddPareja Ap;
	ConsultarClasificacion Cc;
	ListaParejaEli Ep;
	
	public ControladorNuevoTorneo (Modelo mo, NuevoTorneo nt){
		this.Mo = mo;
		this.Nt = nt;
		Nt.btnAnadirPareja.addActionListener(this);
		Nt.btnConsultarParejas.addActionListener(this);
		Nt.btnEliminarPareja.addActionListener(this);
		Nt.btnComenzar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(Nt.btnAnadirPareja.equals(ae.getSource())) 
		{
			Ap = new AddPareja();
			new ControladorAddPareja(Ap, Mo);
		} else if(Nt.btnConsultarParejas.equals(ae.getSource())) 
		{
			Cc = new ConsultarClasificacion();
			new ControladorConsultarClasificacion(Cc, Mo);
		} else if(Nt.btnEliminarPareja.equals(ae.getSource())) 
		{
			Ep = new ListaParejaEli();
			new ControladorEliminarPareja(Ep, Mo);
		} else if(Nt.btnComenzar.equals(ae.getSource())) 
		{
			new Torneo(Nt.lblNombre.getText());
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
		System.exit(0);
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
