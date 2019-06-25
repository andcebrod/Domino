package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class ControladorMenuPrincipal implements WindowListener, ActionListener{

	Modelo Mo;
	MenuPrincipal Mp;
	NuevoTorneo Nt;
	Calendar horaFecha;
	int dia,mes,anyo;
	String fecha;
	
	public ControladorMenuPrincipal(MenuPrincipal mp, Modelo mo) {
		this.Mo = mo;
		this.Mp = mp;
		mp.btnNuevo.addActionListener(this);
		mp.btnContinuar.addActionListener(this);
		mp.btnAyuda.addActionListener(this);
		mp.btnAceptar.addActionListener(this);
		mp.btnCancelar.addActionListener(this);
		mp.addWindowListener(this);
		horaFecha = Calendar.getInstance();

		
		dia = horaFecha.get(Calendar.DAY_OF_MONTH);
		mes = horaFecha.get(Calendar.MONTH)+1;
		anyo = horaFecha.get(Calendar.YEAR);
		fecha = anyo+"/"+mes+"/"+dia;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(Mp.btnNuevo.equals(ae.getSource())) {
			Mp.dlgNombre.setVisible(true);
		}
		if(Mp.btnAceptar.equals(ae.getSource())) 
		{
			String nombre = Mp.txtNombre.getText();
			Mo.ejecutarIDA("INSERT INTO campeonatos (`nombreCampeonato`, `fechaCampeonato`) VALUES ('"+nombre+"', '"+fecha+"');", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Torneo Creado con éxito.");
			ResultSet rs = Mo.ejecutarSelect("SELECT * FROM campeonatos order by 1;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
			
			try 
			{
				rs.next();
				Nt = new NuevoTorneo(nombre, rs.getInt("idCampeonato"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			}
			new ControladorNuevoTorneo(Mo, Nt);
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
