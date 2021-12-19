import javax.swing.*;


public class Test extends JFrame {
    private JPanel mainPanel = new JPanel();

    public Test(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField f = new JTextField(10);
        mainPanel.add(f);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main (String[] args){
        JFrame frame = new Test("HomePage");
        frame.setVisible(true);
    }
}
