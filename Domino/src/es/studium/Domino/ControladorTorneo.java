package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorTorneo implements ActionListener, WindowListener
{
	int i=1;
	int j=i+1;
	int numParejas;
	String sentencia;

	Torneo To;
	Modelo Mo;
	public ControladorTorneo(Torneo to, Modelo mo) 
	{
		this.To = to;
		this.Mo = mo;
		To.btnJugarPartida.addActionListener(this);
		To.modeloTabla.addColumn("Mesa");
		To.modeloTabla.addColumn("Pareja 1");
		To.modeloTabla.addColumn("Pareja 2");
		To.modeloTabla.addColumn("Número Partida");
		ResultSet nP = Mo.ejecutarSelect("SELECT count(idPareja) FROM parejas;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
		try {
			nP.next();
			numParejas = nP.getInt("count(idPareja)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error 1",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		int p=0;
		int k;
		int m=0;
		while(i<=numParejas) 
		{
			sentencia = "SELECT idPareja, Jugador1, Jugador2 FROM parejas where idPareja= "+i+" OR idPareja = "+j+" order by 1;";
			ResultSet rs = Mo.ejecutarSelect(sentencia, Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
			Object [] fila = new Object[4];
			try {
				rs.next();
				String Pareja1;
				String Pareja2;
				
				for (k=0;k<=1;k++) {
					if (k==0) 
					{
						p++;
						fila[0]=p;
					} else if(k==1)
					{
						Pareja1 = Integer.toString(rs.getInt("idPareja"));
						Pareja1 = Pareja1+".-"+rs.getString("Jugador1")+", "+rs.getString("Jugador2");
						fila[1] = Pareja1;
					}
				}
				rs.next();
				for(k=2;k<=3;k++) 
				{
					if(k==2)
					{
						Pareja2 = rs.getString("idPareja");
						Pareja2 = Pareja2+".-"+rs.getString("Jugador1")+", "+rs.getString("Jugador2");
						fila[2] = Pareja2;
					} else if(k==3) 
					{
						m++;
						fila[3]=m;
					}
				}
				To.modeloTabla.addRow(fila); 

			} catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error 2", JOptionPane.ERROR_MESSAGE);
			}
			i=i+2;
			j=i+1;
		}

		Mo.desconectar(Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
	}



	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub


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
	public void windowClosing(WindowEvent ae) {
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
