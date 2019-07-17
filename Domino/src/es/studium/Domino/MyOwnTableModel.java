package es.studium.Domino;
import javax.swing.table.DefaultTableModel;
public class MyOwnTableModel extends DefaultTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Define la posibilidad de editar de una columna.
     */
    private final boolean [] tableColums = {false, false, false, false};
     
    @Override
    public final boolean isCellEditable(int row, int column) {
        return this.tableColums[column];
    }

}
