package bank;

import javax.swing.*;

public class account extends JFrame {
    public account() {
        setTitle("Account Page");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to your account!");
        welcomeLabel.setBounds(80, 80, 200, 60);
        add(welcomeLabel);

        // Additional components for the account page can be added here
        // For example, buttons to view balance, logout, etc.

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 50, 75, 50);
        add(logoutButton);

        logoutButton.addActionListener(e -> {
            // Close the account page and return to login page
            dispose();
            new Login().setVisible(true);
        });
    }
}
