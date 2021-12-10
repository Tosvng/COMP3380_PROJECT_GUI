import javax.swing.*;
import java.util.ArrayList;

public class ResultPage extends JFrame {

    private JFrame f = new JFrame();
    //private SearchMovieDAO searchDAO = new SearchMovieDAO();

    private JTable table;
    private JPanel mainResultPanel;

    private ArrayList<Result> display;

    public ResultPage(String title) {
        super(title);
        this.setContentPane(mainResultPanel);
        this.pack();

        display = SearchPage.getResult();
        ResultsTable model = new ResultsTable(display);
        table.setModel(model);

    }
}
