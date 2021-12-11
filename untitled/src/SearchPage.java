import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPage extends JFrame {


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
    private JButton searchButton;

    private JFrame f = new JFrame();
    private SearchMovieDAO searchDAO = new SearchMovieDAO();
    private static ArrayList<Result> result;


    public SearchPage(String title){
        super(title);
        this.setContentPane(mainSearchPanel);
        this.pack();


        /*allMoviesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDAO = new SearchMovieDAO();
                result= null;
                result = searchDAO.showAllMovies(); // get the result of the query
                showResultPage();

            }
        });*/
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) showWithBox.getSelectedItem(); // the value that was selected in the combo box drop down
                int indexSelected = showWithBox.getSelectedIndex();
                System.out.println(indexSelected);
                String title = titleText.getText();
                String movieID = movieIdText.getText();
                String releaseDate = releaseDateText.getText();

                if(allMoviesBox.isSelected() & selected.equalsIgnoreCase("Show with")){//when show all movies is checked
                    allMovies();
                    showResultPage();
                }

                else if(title.isEmpty() && movieID.isEmpty() && releaseDate.isEmpty()){
                    switch (indexSelected){
                        case 1:
                            allCasts();
                            showResultPage();
                        case 5:
                            producedBy();
                            showResultPage();
                        default:
                            allMovies();
                    }

                }

            }
        });
    }

    //return the result of a query. Mainly used by the class for displaying the table
    public static ArrayList<Result> getResult(){
        return result;
    }

    public void showResultPage(){
        ResultPage resPage = new ResultPage("Result");
        resPage.setVisible(true);
    }

    public void allMovies(){

        result= null;
        result = searchDAO.showAllMovies(); // get the result of the query
    }

    public void allCasts(){
        result= null;
        result = searchDAO.moviesXactors();
    }

    public void producedBy(){
        result = null;
        result = searchDAO.producedBy();
    }

    // revenue and budget would be buttons that create a new page to select grater than or less than and runtime
}
