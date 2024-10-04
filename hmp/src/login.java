import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel2;
    private JMenuBar jMenuBar1;
    private JMenu jMenu1, jMenu2;
    private JMenuItem jMenuItem1, jMenuItem2;

    public Main() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 122, 235));

        jLabel2.setFont(new java.awt.Font("Impact", 1, 36)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hospital Management System");

        jMenu1.setText("Admin");
        jMenuItem1.setText("New User");

        jMenu1.add(jMenuItem1);
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        // Layout and other components initialization
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
