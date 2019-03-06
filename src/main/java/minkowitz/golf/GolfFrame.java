package minkowitz.golf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GolfFrame extends JFrame
{
    public GolfFrame()
    {
        setTitle("KAILA'S WONDERFUL GOLFING EMPORIUM");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JLabel north = new JLabel(new ImageIcon("GOOGLE.png"));
        north.setPreferredSize(new Dimension(50,50));
        root.add(north, BorderLayout.NORTH);

        JLabel south = new JLabel("South");
        south.setBackground(Color.MAGENTA);
        south.setOpaque(true);
        root.add(south, BorderLayout.SOUTH);

        JLabel west = new JLabel("West");
        west.setBackground(Color.cyan);
        west.setOpaque(true);
        west.setText("KAILA IS THE CHIEF NINJA. ALL HAIL CHIEF NINJA");
        root.add(west, BorderLayout.WEST);

        JButton center = new JButton("Center");
        center.setBackground(Color.LIGHT_GRAY);
        center.setOpaque(true);
        center.addActionListener(this::printClick);
        root.add(center, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent)
    {
        System.out.println("i been clicked");
    }
}
