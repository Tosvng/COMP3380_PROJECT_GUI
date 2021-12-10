import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPage extends JFrame {
    private JFrame f = new JFrame();
    private SearchMovieDAO searchDAO = new SearchMovieDAO();
    private JPanel mainSearchPanel;
    private JPanel moviePanel;
    private JCheckBox allMoviesBox;
    private JButton runTimeButton;
    private JTextField movieIdText;
    private JTextField titleText;
    private JTextField releaseDateText;
    private JComboBox showWithBox;
    private JButton revenueButton;
    private JButton budgetButton;
    private static ArrayList<Result> result;


    public SearchPage(String title){
        super(title);
        this.setContentPane(mainSearchPanel);
        this.pack();
        allMoviesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                result= null;
                result = searchDAO.showAllMovies(); // get the result of the query
                ResultPage resPage = new ResultPage("Result");
                resPage.setVisible(true);

            }
        });
    }

    public static ArrayList<Result> getResult(){
        return result;
    }

    // revenue and budget would be buttons that create a new page to select grater than or less than and runtime
}
