import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Email Registration");
        frame.setLayout(new GridLayout(5, 2));
        
        JLabel lblName = new JLabel("Name:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        JLabel lblMessage = new JLabel();
        
        JTextField txtName = new JTextField();
        JTextField txtEmail = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JPasswordField txtConfirmPassword = new JPasswordField();
        
        JButton btnSubmit = new JButton("Submit");

        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(lblPassword);
        frame.add(txtPassword);
        frame.add(lblConfirmPassword);
        frame.add(txtConfirmPassword);
        frame.add(btnSubmit);
        frame.add(lblMessage);
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());
                
                if(password.equals(confirmPassword)) {
                    lblMessage.setText("Registration Successful!");
                } else {
                    lblMessage.setText("Passwords do not match!");
                }
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
