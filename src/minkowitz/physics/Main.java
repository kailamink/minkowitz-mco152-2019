package minkowitz.physics;

import java.util.ArrayList;
import java.util.Random;
//list of projectiles every second we're going to add 5 projectiles
//projectiles will have  a velocity in the range of 50 to 120 aka 70
//degrees from 30 to 150 aka 120
//every second we'll add between 0 and 5 projectiles
//all inclusive
//after 120 seconds print all projectiles where y is greater than 0

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Projectile> rockets = new ArrayList<>();
        Random rand = new Random();
        final int upperBoundOfRockets = 6;
        final int lowerBoundTheta = 30;
        final int upperBoundTheta = 121;
        final int lowerBoundVelocity = 50;
        final int upperBoundVelocity = 71;

        for(int time = 0; time < 120; ++time)
        {
            int numberOfRocketsToAdd = rand.nextInt(upperBoundOfRockets);
            for (Projectile p : rockets)
            {
                p.addTime(1);
            }
            for(int ix = 0; ix <= numberOfRocketsToAdd; ++ix)
            {
                rockets.add(new Projectile(rand.nextInt(upperBoundTheta) + lowerBoundTheta,
                                            rand.nextInt(upperBoundVelocity) + lowerBoundVelocity));
            }
        }
        rockets.stream()
                .filter(p -> p.getY() > 0)
                .forEach(System.out::println);
    }
}
