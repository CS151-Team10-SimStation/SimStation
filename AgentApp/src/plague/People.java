package plague;

import mvc.Utilities;
import simstation.*;

public class People extends Agent {
    private int speed;
    private boolean infected;

    public People() {
        super();
        heading = (Heading.NORTH);
        speed = Utilities.rng.nextInt(11) + 1;
        if(Utilities.rng.nextInt(100) < PlagueSimulation.INITIAL_INFECTION_PERCENT)
            infected = true;
        else
            infected = false;
    }

    @Override
    public void update() {
        heading = heading.random();        //plagued person moves like a drunk
        speed = Utilities.rng.nextInt(11);
        move(speed);
        infect();       //calls the infect method to see if this person can infect a neighbor
    }


    public void infect()
    {
        People neighbor = (People)(world.getNeighbor(this, 10.0));    //try to infect neighbor
        double infection_Chance = (PlagueSimulation.VIRULENCE/100) * ((100 - PlagueSimulation.RESISTANCE)/100); //The chance of infection depending on virulence and resistance
        //check if this user can infect
        if(this.getInfected() && neighbor != null) {
            //generate random num from 0-100;
            // Infect neighbor if infection chance is greater and neighbor not already infected.
            if(Utilities.rng.nextInt(101) <= infection_Chance * 100 && !neighbor.getInfected()) {
                neighbor.setInfected(true);
                world.changed();
            }
        }
    }

    public boolean getInfected() { return infected; }
    public void setInfected(boolean val) { infected = val; }
    public synchronized int getSpeed() { return speed; }

}
