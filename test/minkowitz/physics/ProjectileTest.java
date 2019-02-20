package minkowitz.physics;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectileTest {

    @Test
    public void getLocationAfter3Seconds()
    {
        //given
        Projectile p = new Projectile(48,67);

        //when
        p.addTime(3);

        //then
        double x = p.getX();
        double y = p.getY();
        assertEquals(134.49, x, 0.01);
        assertEquals(105.27, y, 0.01);
    }

}