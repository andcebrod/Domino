package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener{

	Modelo Mo;
	MenuPrincipal Mp;
	NuevoTorneo Nt;
	
	public Controlador(MenuPrincipal mp, Modelo mo) {
		this.Mo = mo;
		this.Mp = mp;
		mp.btnNuevo.addActionListener(this);
		mp.btnContinuar.addActionListener(this);
		mp.btnAyuda.addActionListener(this);
		mp.btnAceptar.addActionListener(this);
		mp.btnCancelar.addActionListener(this);
		mp.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(Mp.btnNuevo.equals(ae.getSource())) {
			Mp.dlgNombre.setVisible(true);
		}
		if(Mp.btnAceptar.equals(ae.getSource())) {
			String nombre = Mp.txtNombre.getText();
			new NuevoTorneo(nombre);
			Mp.dlgNombre.setVisible(false);
			Mp.setVisible(false);
		} else if(Mp.btnCancelar.equals(ae.getSource())) {
			Mp.dlgNombre.setVisible(false);
			Mp.setVisible(true);
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
