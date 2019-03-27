package minkowitz.golf;

import javax.swing.*;
import java.awt.*;

public class InputFrame extends JComponent
{
    public JPanel createControlPanel(GolfCourseComponent golfy)
    {
        JPanel panel = new JPanel();
        JLabel velLabel = new JLabel("Velocity: ");
        JTextField velText = new JTextField("", 4);
        JLabel angLabel = new JLabel("Angle: ");
        JTextField angText = new JTextField("", 4);
        JButton button = new JButton("GO!");
        button.addActionListener(e -> {
            golfy.create(Double.parseDouble(angText.getText()), Double.parseDouble(velText.getText()));
        });
        panel.add(velLabel);
        panel.add(velText);
        panel.add(angLabel);
        panel.add(angText);
        panel.add(button);
        return panel;
    }

}
