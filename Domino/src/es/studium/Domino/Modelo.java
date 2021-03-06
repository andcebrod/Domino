package es.studium.Domino;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Modelo 
{
	
	String baseDeDatos ="domino";
	String contrasena ="Studium2018;";
	String usuario = "root";
	
	public Connection conectar(String baseDatos, String usuario, String contrasena)
	{
		String driver = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/"+baseDatos+"?autoReconnect=true&useSSL=false";
		String login = usuario;
		String password = contrasena;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login,password);
		}
		catch (ClassNotFoundException cnfe)
		{
			JOptionPane.showMessageDialog(null,"Error",cnfe.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,"Error",sqle.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		return connection;
	}
	public void desconectar(Connection c) 
	{
		try
		{
			if(c!=null)
			{
				c.close();
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Error",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

	public ResultSet ejecutarSelect(String sentencia, Connection c) 
	{
		try
		{
			Statement statement = c.createStatement();
			ResultSet rs= statement.executeQuery(sentencia);
			return rs;
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Error",e.getMessage(), JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}
	public void ejecutarIDA(String sentencia, Connection c, String mensajeOK) 
	{
		try
		{
			Statement statement = c.createStatement();
			statement.executeUpdate(sentencia);
			JOptionPane.showMessageDialog(null,"�xito",mensajeOK, JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void ejecutarIDASIN(String sentencia, Connection c) 
	{
		try
		{
			Statement statement = c.createStatement();
			statement.executeUpdate(sentencia);
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String Calendario() {
		Calendar horaFecha = Calendar.getInstance();
		int hora,minutos,dia,mes,anyo;
		hora = horaFecha.get(Calendar.HOUR_OF_DAY);
		minutos = horaFecha.get(Calendar.MINUTE);
		dia = horaFecha.get(Calendar.DAY_OF_MONTH);
		mes = horaFecha.get(Calendar.MONTH)+1;
		anyo = horaFecha.get(Calendar.YEAR);
		if(dia<10 && mes<10) 
		{
			return "0"+dia+"/"+"0"+mes+"/"+anyo;
		} else if(dia<10 && mes>10) 
		{
			return "0"+dia+"/"+mes+"/"+anyo;
		} else if (dia>10 && mes<10) 
		{
			return dia+"/"+"0"+mes+"/"+anyo;
		} else if(dia>10 && mes<10) 
		{
			return dia+"/"+mes+"/"+anyo;
		} else 
		{
			return null;
		}
	}

}
