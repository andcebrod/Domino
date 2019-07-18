package es.studium.Domino;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class ControladorTorneoPrimeraJornada implements ActionListener, WindowListener
{
	int i=1;
	int j=i+1;
	int numParejas;
	String sentencia;
	Partida pt;
	int Campeonato;
	TorneoPrimeraJornada To;
	Modelo Mo;
	int idPareja1;
	int idPareja2;
	int Jornada;
	Torneo to2;
	ControladorTorneo Cot;
	ConsultarClasificacion Cc;
	Color[] rowColors;
	Color[] rowColors2;
	Color[] rowColors3;
	
	public ControladorTorneoPrimeraJornada(TorneoPrimeraJornada to, Modelo mo) 
	{
		
		this.To = to;
		this.Mo = mo;
		To.mniConsClasificacion.addActionListener(this);
		To.btnJugarPartida.addActionListener(this);
		To.mniAvanzarJornada.addActionListener(this);
		To.modeloTabla.addColumn("Mesa");
		To.modeloTabla.addColumn("Pareja 1");
		To.modeloTabla.addColumn("Pareja 2");
		To.modeloTabla.addColumn("Número Partida");
		To.tablaParejas.setRowHeight(30);
		rowColors = new Color[] {Color.white, Color.white, Color.white, Color.white};
		rowColors2 = new Color[] {Color.black, Color.black, Color.black, Color.black};
		rowColors3 = new Color[] {Color.gray, Color.gray, Color.gray, Color.gray};
		To.tablaParejas.setDefaultRenderer(Object.class, new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
				JLabel LblDato = new JLabel();
				JPanel pane = new JPanel();
				pane.setBackground(rowColors[row]);
				pane.setForeground(rowColors2[row]);
				LblDato.setText(To.modeloTabla.getValueAt(row, column).toString()); 
				if(isSelected) {
					pane.setBackground(rowColors3[row]);
				}
				pane.add(LblDato);
				return pane;
				
			}
		});
		
		
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
						Pareja1 = Pareja1+".-"+rs.getString("Jugador1")+" Y "+rs.getString("Jugador2");
						fila[1] = Pareja1;
					}
				}
				rs.next();
				for(k=2;k<=3;k++) 
				{
					if(k==2)
					{
						Pareja2 = rs.getString("idPareja");
						Pareja2 = Pareja2+".-"+rs.getString("Jugador1")+" Y "+rs.getString("Jugador2");
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
		if(To.btnJugarPartida.equals(ae.getSource())) 
		{
			int filaSelecionada;
			int mesa;
			String Pareja1;
			String Pareja2;
			Campeonato = To.idCampeonato;
			filaSelecionada = To.tablaParejas.getSelectedRow();
			mesa = Integer.parseInt(To.modeloTabla.getValueAt(filaSelecionada, 0).toString());
			Pareja1 = To.modeloTabla.getValueAt(filaSelecionada, 1).toString();
			Pareja2 = To.modeloTabla.getValueAt(filaSelecionada, 2).toString();
			String[] arrayPareja1 = Pareja1.split(".-");
			String[] arrayPareja2 = Pareja2.split(".-");
			idPareja1 = Integer.parseInt(arrayPareja1[0]);
			idPareja2 = Integer.parseInt(arrayPareja2[0]);
			
			rowColors[filaSelecionada] = Color.RED;
			To.tablaParejas.repaint();
			
			pt = new Partida(arrayPareja1[1],arrayPareja2[1], idPareja1, idPareja2, Campeonato,1,mesa);
			new ControladorPartida(pt, Mo);
	
		} else if(To.mniAvanzarJornada.equals(ae.getSource())) 
		{
			int pos =1;
			ResultSet rsPosiciones = Mo.ejecutarSelect("SELECT * FROM parejas order by puntosClasificacion desc, diferencia desc, puntosAFavor desc;", Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
			try {
				while(rsPosiciones.next()) {
					Mo.ejecutarIDASIN("UPDATE parejas SET posicion ="+pos+" where idPareja = "+rsPosiciones.getInt("idPareja")+";",  Mo.conectar(Mo.baseDeDatos, Mo.usuario, Mo.contrasena));
					pos++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			to2 = new Torneo(To.nombre, To.idCampeonato, 1);
			Cot = new ControladorTorneo(to2, Mo);
			To.setVisible(false);
		}
		else if(To.mniConsClasificacion.equals(ae.getSource())) {
			Cc = new ConsultarClasificacion();
			new ControladorConsultarClasificacion(Cc, Mo);
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
