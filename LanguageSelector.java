import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageSelector {
    // Declare components
    private JFrame frame;
    private JComboBox<String> languageComboBox;
    private JButton showButton;
    private JLabel resultLabel;

    public LanguageSelector() {
        // Set up the frame
        frame = new JFrame("Language Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        // Create components
        JLabel instructionLabel = new JLabel("Select a language: ");
        String[] languages = { "English", "Spanish", "French", "German", "Italian" };
        languageComboBox = new JComboBox<>(languages);
        showButton = new JButton("Show");
        resultLabel = new JLabel("Selected Language: None");

        // Set layout for the frame
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(instructionLabel);
        frame.add(languageComboBox);
        frame.add(showButton);
        frame.add(resultLabel);

        // Action listener for the "Show" button
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected language from the JComboBox
                String selectedLanguage = (String) languageComboBox.getSelectedItem();
                // Display the selected language on the JLabel
                resultLabel.setText("Selected Language: " + selectedLanguage);
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the program on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LanguageSelector();
            }
        });
    }
}
