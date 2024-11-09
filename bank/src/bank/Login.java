package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Username label and field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 30, 130, 30);
        add(usernameField);

        // Password label and field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 70, 130, 30);
        add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(90, 110, 100, 30);
        add(loginButton);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Placeholder for authentication logic
        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose(); // Close the login frame
            new account().setVisible(true); // Open the account page
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials, please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login frame = new Login();
            frame.setLocationRelativeTo(null);  // Center the frame
            frame.setVisible(true);
        });
    }
}
