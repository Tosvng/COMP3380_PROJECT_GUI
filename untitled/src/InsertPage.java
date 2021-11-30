import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import  java.awt.Container.*;

public class InsertPage extends JFrame {

    private JPanel mainInsertPanel;

    //movie
    private JPanel moviePanel;
    private JTextField titleTextField;
    private JLabel movieTitleLabel;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel movieIdLabel;
    private JTextField movieIdTextField;
    private JLabel runtimeLabel;
    private JTextField runTimeTextField;
    private JLabel budgetLabel;
    private JTextField budgetTextField;
    private JButton movieSaveButton;
    //--------------------------
    private String titleText;
    private String dateText;
    private String movieIdText;
    private int movieId;
    private int runTime;
    private int budget;

    //actor
    private JPanel actorPanel;
    private JLabel actorIdLabel;
    private JTextField actorIdTextField;
    private JLabel actorNameLabel;
    private JTextField actNameTextField;

    //crew
    private JPanel crewPanel;
    private JLabel crewIdLabel;
    private JTextField crewIdTextField;
    private JLabel crewNameLabel;
    private JTextField crewNTextField;

    //department
    private JPanel departmentPanel;
    private JLabel deptIdLabel;
    private JLabel deptNameLabel;
    private JTextField deptIdTextField;
    private JComboBox deptComboBox;

    private JPanel insertAuxPanel;
    private JButton insertSaveButton;

    private JPanel messagePanel;
    private JLabel insertLabel;


    //----------------------------------

    private JFrame f = new JFrame();
    private MovieDAO moviedao = new MovieDAO();

    public  InsertPage(String title){
        super(title);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainInsertPanel);
        this.pack();

        //**************SaveButton********************************
        movieSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertMovieData();
            }
        });

        //********check input characters*****************************
        movieIdTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }



    //insert the data in the movie panel method-----------------------
    /********Date isn't done yet**************/
    public void insertMovieData(){

        String runTimeText;
        String budgetText;

        titleText = titleTextField.getText();
        movieIdText = movieIdTextField.getText();
        //check if the title & id are empty
        if(titleText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter a Movie title");
        }
        else if(movieIdText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter a Movie ID");
        }
        else{
            runTimeText = runTimeTextField.getText();
            budgetText = budgetTextField.getText();
            moviedao.insertToMovies(movieIdText, titleText, dateText, runTimeText, budgetText);

        }


    }

    public void insertActorData(){

        String  aIdText = actorIdTextField.getText();
        String nameText = actNameTextField.getText();
        if(aIdText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter the actor's ID");
        }
        else if(nameText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter the actor's name");
        }
        else{
            moviedao.insertToActors(aIdText,nameText);
        }
    }

    public void insertCrewData(){

        String  cIdText = crewIdTextField.getText();
        String nameText = crewNTextField.getText();
        if(cIdText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter the crew member ID");
        }
        else if(nameText.isEmpty()){
            JOptionPane.showMessageDialog(f,"You need to enter the crew member name");
        }
        else{
            moviedao.insertToActors(cIdText,nameText);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here



    }
}
