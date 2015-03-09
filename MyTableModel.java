
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Title", "Creator", "Type", "Score", "ID"};
    private Object[][] data = {
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        };
    @Override
    public int getColumnCount() {
        return columnNames.length - 1;
    }
    @Override
    public int getRowCount() {
        return data.length;
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        try{
        System.out.println(value);
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Du kan inte lägga till fler i denna tabell. "
                    + "för detta programm innehåller för mycket fel");
        }
    }
  

}
