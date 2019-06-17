package es.studium.Domino;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ListaParejaEli extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnEliminar = new JButton("Eliminar Pareja");
	JButton btnCancelar = new JButton("Cancelar");
	Choice Parejas = new Choice();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	/**
	 * Launch the application.
	 */
	
	public ListaParejaEli() {
		setBounds(100, 100, 476, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3,1));
		
		contentPane.add(panel);
		
		JLabel lblSeleccioneParejaA = new JLabel("Seleccione Pareja a eliminar:");
		panel.add(lblSeleccioneParejaA);
		lblSeleccioneParejaA.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSeleccioneParejaA.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Parejas);
		contentPane.add(panel_1);
		panel_1.add(btnEliminar);
		panel_1.add(btnCancelar);
		this.setVisible(true);
	}

}
