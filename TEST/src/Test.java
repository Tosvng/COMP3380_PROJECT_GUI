import javax.swing.*;


public class Test extends JFrame {
    private JPanel mainPanel;

    public Test(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main (String[] args){
        JFrame frame = new Test("HomePage");
        frame.setVisible(true);
    }
}
