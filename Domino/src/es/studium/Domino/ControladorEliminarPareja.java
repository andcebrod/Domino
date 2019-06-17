package es.studium.Domino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorEliminarPareja implements WindowListener, ActionListener
{
	ListaParejaEli El;
	Modelo Mo;
	String pareja;
	int idParejaBorrar;
	public ControladorEliminarPareja(ListaParejaEli el,Modelo mo) {
		this.El = el;
		this.Mo = mo;
		El.btnEliminar.addActionListener(this);
		El.btnCancelar.addActionListener(this);
		El.Parejas.add("Seleccione aquí la pareja que quiera eliminar...");
		//Insertar parejas en choice
		ResultSet rs = Mo.ejecutarSelect("Select idPareja, jugador1, jugador2 FROM Parejas;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
		try {
			while(rs.next()) {

				pareja = rs.getString("idPareja");
				pareja = pareja+".-"+rs.getString("jugador1")+" y "+rs.getString("jugador2");
				El.Parejas.add(pareja);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(El.btnEliminar.equals(ae.getSource())) 
		{
			int seleccion = JOptionPane.showOptionDialog( null,"¿Desea eliminar pareja?","Eliminar pareja",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] { "Eliminar", "Cancelar"},"Cancelar");
			if (seleccion == 0){
				try {
					String[] arrayBorrar= El.Parejas.getSelectedItem().split(".-");
					idParejaBorrar = Integer.parseInt(arrayBorrar[0]);
					Mo.ejecutarIDA("DELETE FROM Parejas where idPareja = "+idParejaBorrar+";", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena), "Pareja borrada con éxito");
				} catch (NumberFormatException Nf) {
					JOptionPane.showMessageDialog(null,"Introduzca una pareja válida","Error de pareja", JOptionPane.ERROR_MESSAGE);
				}

			}
		} else if(El.btnCancelar.equals(ae.getSource())) {
			El.setVisible(false);
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
		El.setVisible(false);
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
