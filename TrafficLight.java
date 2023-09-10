package semIV;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TrafficLight extends JFrame {
    private static final long serialVersionUID = 1L;

    private JRadioButton redButton;
    private JRadioButton yellowButton;
    private JRadioButton greenButton;

    private JLabel statusLabel;

    public TrafficLight() {
        super("Traffic Light");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Add a label to show the status message
        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(statusLabel);

        // Create radio buttons for each light
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group the radio buttons so that only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        // Add radio buttons to a panel
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(greenButton);
        add(radioPanel);



        // Add action listeners to the radio buttons to update the status message
        redButton.addActionListener(e -> setStatusLabel("Stop", Color.RED));
        yellowButton.addActionListener(e -> setStatusLabel("Ready", Color.YELLOW));
        greenButton.addActionListener(e -> setStatusLabel("Go", Color.GREEN));

        // Set the initial state of the traffic light to red
        redButton.setSelected(true);

        setVisible(true);
    }

    private void setStatusLabel(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
