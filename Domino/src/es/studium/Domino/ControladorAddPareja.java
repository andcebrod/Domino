package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorAddPareja implements WindowListener, ActionListener{
	AddPareja Ap;
	Modelo Mo;
	
	public ControladorAddPareja(AddPareja ap, Modelo mo) {
		Ap = ap;
		Mo = mo;
		ap.btnAnadir.addActionListener(this);
		ap.btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(Ap.btnCancelar.equals(ae.getSource())) {
			Ap.setVisible(false);
		} else if(Ap.btnAnadir.equals(ae.getSource())) {
			Mo.ejecutarIDA("INSERT INTO `domino`.`parejas` (`jugador1`, `jugador2`, `localidad`) VALUES ('"+Ap.txtJugador1.getText()+"', '"+Ap.txtJugador2.getText()+"', '"+Ap.txtLocalidad.getText()+"');", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Pareja añadida correctamente.");
			Ap.setVisible(false);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Ap.setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
