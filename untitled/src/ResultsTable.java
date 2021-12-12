import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ResultsTable extends AbstractTableModel {

    private static final int ID_COL = 0;
    private static final int TITLE_COL = 1;
    private static final int NAME_COL = 2;
    private static final int DEPARTMENT_COL = 3;
    private ArrayList<String> columnNames;
    private ArrayList<Result> resultData;

    public ResultsTable(ArrayList<Result> temp ){
        columnNames = new ArrayList<String>();
        resultData = temp;
        String checkForNameColumn = temp.get(0).getName(); // used to check how many columns we need for the table
        String checkForDeptColumn = temp.get(0).getDepartment();

        if(checkForNameColumn == null){// if there is no name column then it has 2 columns
            columnNames.add("ID");
            columnNames.add("Title");
        }
        else if(checkForDeptColumn == null){
            columnNames.add("ID");
            columnNames.add("Title");
            columnNames.add("Name");
        }
        else if(checkForDeptColumn != null){
            columnNames.add("ID");
            columnNames.add("Title");
            columnNames.add("Name");
            columnNames.add("Department");
        }
    }


    @Override
    public int getRowCount() {
        return resultData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int col){
        return columnNames.get(col);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result t = resultData.get(rowIndex);

        return switch (columnIndex) {
            case ID_COL -> t.getId();
            case TITLE_COL -> t.getTitle();
            case NAME_COL -> t.getName();
            case DEPARTMENT_COL -> t.getDepartment();
            default -> null;
        };
    }
}
