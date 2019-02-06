package minkowitz.physics;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

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
        for(int aa = 0; aa < 120; ++aa)
        {
            int numberOfRocketsToAdd = rand.nextInt(6);
            for(int ix = 0; ix <= numberOfRocketsToAdd; ++ix)
            {
                rockets.add(new Projectile(rand.nextInt(121) + 30, rand.nextInt(71) + 50));
            }
            for (Projectile p : rockets)
            {
                p.addTime(1);
            }
        }
        rockets.stream()
                .filter(p -> p.getY() > 0)
                .forEach(System.out::println);
    }
}
