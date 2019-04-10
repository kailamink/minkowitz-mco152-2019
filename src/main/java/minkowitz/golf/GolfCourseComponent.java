package minkowitz.golf;

import minkowitz.physics.Projectile;

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

    private Projectile golfball = null;

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        createSky(graphics);
        int groundHeight = getHeight() * 2 / 3;
        createEarth(graphics,groundHeight);
        createGolfBall(graphics,groundHeight);
        createFlagPole(graphics,groundHeight);
        if(golfball != null)
        {
            golfball.addTime(.01);
        }
        repaint();
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

        double golfX = 0;
        double golfY = 0;
        if(golfball != null)
        {
            golfX = golfball.getX();
            golfY = golfball.getY();
        }
        graphics.fillOval((int) (BALL_START_X + golfX),
                (int)(groundHeight-BALL_WIDTH - golfY),
                BALL_WIDTH,
                BALL_WIDTH);
    }

    public void create(double theta, double velocity)
    {
        golfball = new Projectile(theta, velocity);
    }
}
