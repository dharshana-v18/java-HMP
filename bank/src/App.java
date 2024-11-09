import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // Create a JLabel
        JLabel label = new JLabel("Welcome to Swing!", SwingConstants.CENTER);
        frame.add(label);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
