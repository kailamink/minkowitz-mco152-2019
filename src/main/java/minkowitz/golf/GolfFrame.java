package minkowitz.golf;

import javax.swing.*;
import javax.swing.text.Document;
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

        GolfCourseComponent golfy = new GolfCourseComponent();
        root.add(golfy, BorderLayout.CENTER);

        InputFrame inputy = new InputFrame();
        root.add(inputy.createControlPanel(golfy), BorderLayout.SOUTH);
        setContentPane(root);
    }
}
