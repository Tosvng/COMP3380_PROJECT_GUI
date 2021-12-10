import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ResultsTable extends AbstractTableModel {

    private static final int ID_COL = 0;
    private static final int TITLE_COL = 1;
    private static final int NAME_COL = 2;
    private ArrayList<String> columnNames;
    private ArrayList<Result> resultData;

    public ResultsTable(ArrayList<Result> temp ){
        resultData = temp;
        if(temp.size() == 2){
            columnNames.add("ID");
            columnNames.add("Title");
        }
        else if(temp.size() == 3){
            columnNames.add("ID");
            columnNames.add("Title");
            columnNames.add("Name");
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
            default -> null;
        };
    }
}
