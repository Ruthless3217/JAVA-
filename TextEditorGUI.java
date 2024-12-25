import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.undo.*;

public class TextEditorGUI {
    // Declare components
    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, helpMenu;
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem, cutMenuItem,copyMenuItem,pasteMenuItem,selectallMenuItem;
    private JMenuItem aboutMenuItem;
    private JFileChooser fileChooser;
    private UndoManager undoManager;

    public TextEditorGUI() {
        // Set up the frame
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Set undo manager
        undoManager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));

        // Create a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the menu bar
        menuBar = new JMenuBar();

        // Create File menu
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");

        // Create Edit menu
        editMenu = new JMenu("Edit");
        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Paste");
        selectallMenuItem = new JMenuItem("Select All");

        // Create Help menu
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");

        // Add action listeners for menu items
        newMenuItem.addActionListener(e -> textArea.setText(""));

        openMenuItem.addActionListener(e -> openFile());

        saveMenuItem.addActionListener(e -> saveFile());

        exitMenuItem.addActionListener(e -> System.exit(0));


        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Simple Text Editor\nVersion 1.0"));

        // Add menu items to File menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Add menu items to Edit menu
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(selectallMenuItem);

        // Add menu items to Help menu
        helpMenu.add(aboutMenuItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Add the scroll pane to the frame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create file chooser
        fileChooser = new JFileChooser();

        // Make the frame visible
        frame.setVisible(true);
    }

    private void openFile() {
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error opening file: " + e.getMessage());
            }
        }
    }

    private void saveFile() {
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Run the program on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditorGUI();
            }
        });
    }
}
