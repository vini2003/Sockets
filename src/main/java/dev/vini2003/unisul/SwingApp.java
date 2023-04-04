package dev.vini2003.unisul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class SwingApp extends JFrame {
    private JTextField urlField;
    private JButton openButton;
    private JButton closeButton;
    private JEditorPane editorPane;

    public SwingApp() {
        setTitle("Java 17 Swing Application");
        setSize(800, 600);

        // Create the components
        urlField = new JTextField(40);
        openButton = new JButton("Open");
        closeButton = new JButton("Close");
        editorPane = new JEditorPane();

        // Set up the layout
        JPanel urlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        urlPanel.add(urlField);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(openButton);
        buttonsPanel.add(closeButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(urlPanel, BorderLayout.WEST);
        topPanel.add(buttonsPanel, BorderLayout.EAST);

        // Set up the JEditorPane
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);

        // Add components to the JFrame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listeners
        openButton.addActionListener(e -> {
            try {
                URL url = new URL(urlField.getText());
                editorPane.setPage(url);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        closeButton.addActionListener(e -> System.exit(0));

        // Add window listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingApp app = new SwingApp();
            app.setVisible(true);
        });
    }
}
