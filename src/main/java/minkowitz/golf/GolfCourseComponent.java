package minkowitz.golf;

import javax.swing.*;
import java.awt.*;

public class GolfCourseComponent extends JComponent
{

    private static final int BALL_WIDTH = 15;
    private static final int BALL_START_X = 20;
    private static final int FLAG_X = 500;
    private static final int POLE_WIDTH = 5;
    private static final int POLE_HEIGHT = 100;
    private static final int FLAG_WIDTH = 26;

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        createSky(graphics);
        int groundHeight = getHeight() * 2 / 3;
        createEarth(graphics,groundHeight);
        createGolfBall(graphics,groundHeight);
        createFlagPole(graphics,groundHeight);
    }

    private void createFlagPole(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.BLACK);
        int flagY = groundHeight- POLE_HEIGHT;
        graphics.fillRect(FLAG_X,
                flagY,
                POLE_WIDTH,
                POLE_HEIGHT);
        graphics.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(FLAG_X, flagY);
        polygon.addPoint(FLAG_X, flagY+FLAG_WIDTH);
        polygon.addPoint(FLAG_X-FLAG_WIDTH, flagY+FLAG_WIDTH/2);
        graphics.fillPolygon(polygon);
    }

    private void createSky(Graphics graphics)
    {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(
                0,
                0,
                getWidth(),
                getHeight());
    }

    private void createEarth(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(
                0,
                groundHeight,
                getWidth(),
                getHeight());
    }

    private void createGolfBall(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillOval((int) (BALL_START_X),
                groundHeight-BALL_WIDTH,
                BALL_WIDTH,
                BALL_WIDTH);
    }
}
