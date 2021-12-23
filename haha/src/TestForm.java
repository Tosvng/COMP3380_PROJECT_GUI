import javax.swing.*;


public class TestForm extends JFrame {
    private JPanel mainPanel ;

    public TestForm(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main (String[] args){
        JFrame frame = new TestForm("HomePage");
        frame.setVisible(true);
    }
}
