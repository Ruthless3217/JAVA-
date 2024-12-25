import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI
 {
    // Declare components
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginGUI() {
        // Set up the frame
        frame = new JFrame("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        
        // Create panels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        
        loginButton = new JButton("Login");
        statusLabel = new JLabel(" ");

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check username and password
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                
                // Simple validation
                if (username.equals("admin") && new String(password).equals("password")) {
                    statusLabel.setText("Login Successful!");
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        });
        
        // Add components to panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(loginButton);

        // Add components to frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(statusLabel, BorderLayout.SOUTH);

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of LoginGUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI();
            }
        });
    }
}
