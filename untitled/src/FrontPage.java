import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame {
    private JPanel mainPanel;
    private JPanel welcomePanel;
    private JLabel welcomeLabel;
    private JButton insertButton;
    private JPanel insertPanel;
    private JPanel searchPanel;
    private JButton searchButton;
    private JButton updateRecordButton;
    private JPanel updatePanel;

    public FrontPage(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        // go to insert page
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertPage insertPage = new InsertPage("Inserting a record");
                insertPage.setVisible(true);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchPage searchPage = new SearchPage("Search for a record");
                searchPage.setVisible(true);
            }
        });
    }

    public static void main (String[] args){
        JFrame frame = new FrontPage("HomePage");
        frame.setVisible(true);
    }
}
