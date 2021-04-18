package flocking;

import mvc.*;
import simstation.*;

/* Revision History
4/16/21: Samantha updated Birds
 */
public class Birds extends Agent {
    private int speed;

    public Birds() {
        super();
        speed = Utilities.rng.nextInt(5) + 1;
        heading = Heading.random();
    }

    public synchronized int getSpeed() {
        return speed;
    }

    @Override
    public void update() {
        Birds neighbor = (Birds) world.getNeighbor(this, 10.0 );
        if (neighbor != null) {
            heading = neighbor.getHeading();
            speed = neighbor.getSpeed();
        }
        move(speed);
    }



}
