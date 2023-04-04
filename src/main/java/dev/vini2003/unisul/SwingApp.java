import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class SwingApp extends JFrame implements ActionListener {
    private JTextField urlField;
    private JButton openButton;
    private JButton closeButton;
    private JEditorPane editorPane;

    public SwingApp() {
        setTitle("Java 17 Swing Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the components
        urlField = new JTextField(40);
        openButton = new JButton("Open");
        closeButton = new JButton("Close");
        editorPane = new JEditorPane();

        // Set up the layout
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(urlField);
        topPanel.add(openButton);
        topPanel.add(closeButton);

        // Set up the JEditorPane
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);

        // Add components to the JFrame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listeners
        openButton.addActionListener(this);
        closeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            try {
                URL url = new URL(urlField.getText());
                editorPane.setPage(url);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == closeButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingApp app = new SwingApp();
            app.setVisible(true);
        });
    }
}
