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

        GolfCourseComponent golfy = new GolfCourseComponent();
        root.add(golfy, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent)
    {
        System.out.println("i been clicked");
    }
}
