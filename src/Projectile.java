public class Projectile
{
    private double theta;
    private double velocity;
    private double time;

    public Projectile(double the, double vel)
    {
        theta = the;
        velocity = vel;
    }
    public void addTime(double deltaTime)
    {
        time += deltaTime;
    }

    public double getX()
    {
        return Math.cos(Math.toRadians(theta)) * velocity * time;
    }

    public double getY()
    {
        double timeSqrd = time * time;
        return Math.sin(Math.toRadians(theta)) * velocity * time - 9.8 * 1/2 * timeSqrd;
    }

    @Override
    public String toString()
    {
        return "time: " + time + " x: " + getX() + " y: " + getY();
    }
}
