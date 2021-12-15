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
    private JPanel genrePanel;
    private JCheckBox allGenreBox;
    private JComboBox selectedGenreBox1;
    private JButton addGenreButton;
    private JComboBox selectedGenreBox2;

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
                String selected = (String) showWithBox.getSelectedItem(); // the value that was selected in the movie combo box drop down
                String selectedGenre1 = (String) selectedGenreBox1.getSelectedItem();// value selected in genre combo box
                int indexSelected = showWithBox.getSelectedIndex();
                int genreIndexSelected1 = selectedGenreBox1.getSelectedIndex();//index of the genre choice selected
                //System.out.println(indexSelected);
                String title = titleText.getText();
                String movieID = movieIdText.getText();
                String releaseDate = releaseDateText.getText();

                if(allMoviesBox.isSelected() && selected.equalsIgnoreCase("Show all Movies with")){//when show all movies is checked
                    showEntityTable("movie");

                }
                else if(allGenreBox.isSelected() && selectedGenre1.equalsIgnoreCase("Select a Genre")){
                    showEntityTable("genre");
                }

                else if(title.isEmpty() && movieID.isEmpty() && releaseDate.isEmpty()){// showing all movies with their relationships
                    if(indexSelected != 0) {
                        switch (indexSelected) {
                            case 1 -> allCasts();
                            case 2 -> appears();
                            case 3 -> category();
                            case 4 -> producedBy();
                            case 5 -> producedIn();
                            case 6 -> works();
                            default -> showEntityTable("movie");
                        }
                    }else if(genreIndexSelected1 != 0){
                        specificGenre(genreIndexSelected1, "movie", (String) selectedGenreBox1.getSelectedItem());
                    }

                }

            }
        });
        // adds a genre to a query
        addGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGenreBox2.setVisible(true);

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

    public void showEntityTable(String entity){

        result= null;
        result = searchDAO.showAll(entity); // get the result of the query
        showResultPage();
    }

    public void allCasts(){
        result= null;
        result = searchDAO.moviesXactors();
        showResultPage();
    }

    public void appears(){
        result= null;
        result = searchDAO.appears();
        showResultPage();
    }

    public void category(){
        result= null;
        result = searchDAO.category();
        showResultPage();
    }

    public void producedIn(){
        result = null;
        result = searchDAO.producedBy();
        showResultPage();
    }

    public void producedBy(){
        result = null;
        result = searchDAO.producedBy();
        showResultPage();
    }

    public void works(){
        result = null;
        result = searchDAO.works();
        showResultPage();
    }

    public void plays(){ // not finished yet
        result= null;
        result = searchDAO.plays();
    }

    //view all of an entities' relation with a particular genre e.g. action,romance
    //int x is the position selected in the comboBox
    // tab is the table genre joins with and choice is the genre name
    public void specificGenre(int x, String tab, String choice){
        result = null;
        switch (x){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                result = searchDAO.specificGenre(tab,choice);
                showResultPage();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + x);
        }

    }

}
