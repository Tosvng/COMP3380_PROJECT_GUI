import javax.swing.*;

public class SearchPage extends JFrame {
    private JFrame f = new JFrame();
    private MovieDAO moviedao = new MovieDAO();
    private JPanel mainSearchPanel;
    private JPanel moviePanel;
    private JCheckBox alllMoviesBox;
    private JButton runTimeButton;
    private JTextField movieIdText;
    private JTextField titleText;
    private JTextField releaseDateText;
    private JComboBox showWithBox;
    private JButton revenueButton;
    private JButton budgetButton;

    public SearchPage(String title){
        super(title);
        this.setContentPane(mainSearchPanel);
        this.pack();
    }

    // revenue and budget would be buttons that create a new page to select grater than or less than and runtime
}
