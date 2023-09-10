package semIV;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.EventQueue;

public class StudentTableExample extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;

    public StudentTableExample() {
        // create a table model with the specified column names
        String[] columnNames = {"Roll Number", "Name", "Percentage"};
        Object[][] data = {{ "001", "Ruskin Bond", 80.2} ,{"002", "Percy Jackson", 80.0}, {"003", "Keera G", 85.5}, {"004", "Annabeth Chase", 99.2},  {"005", "Frank Zhang", 90.2},  {"006", "Piper McLean", 70.2},  {"007", "Jason Grace", 78.2},  {"008", "Hazel Levesque", 84},  {"009", "Nico DiAngelo", 90.7},  {"010", "Anushaka Patil", 81},  {"42", "PACMAN", 100000000}};
        StudentTableModel model = new StudentTableModel(columnNames, data);

        // create a table with the model
        table = new JTable(model);

        // create a panel to hold the table
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(table));

        // set the frame properties
        setTitle("Student Table Example");
        setSize(new Dimension(600, 280));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        // run the application in the event dispatch thread
        EventQueue.invokeLater(() -> {
            StudentTableExample ex = new StudentTableExample();
            ex.setVisible(true);
        });
    }
}

class StudentTableModel extends javax.swing.table.AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames;
    private Object[][] data;

    public StudentTableModel(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @SuppressWarnings("unchecked")
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
