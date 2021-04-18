package randomwalk;

import mvc.AppPanel;
import mvc.Model;
import mvc.Utilities;
import simstation.*;

import javax.swing.*;

/* Revision History
4/16/21 - Samantha updated getHelp() and stats() to show clock time
 */

class Drunk extends Agent {
    private int speed;

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public synchronized int getSpeed() {
        return speed;
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}

class RandomWalkFactory extends SimulationFactory {
    public Model makeModel() {
        return new RandomWalkSimulation();
    }

    public String getTitle() {
        return "Random Walks";
    }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[6];
        cmmds[0] = "Start: starts the simulation";
        cmmds[1] = "Stop: stops the simulation";
        cmmds[2] = "Suspend: temporarily stops/suspends the simulation";
        cmmds[3] = "Resume: resumes the simulation";
        cmmds[4] = "Stats: lists stats of the simulation";
        cmmds[5] = "\nAgents are drunk. They update themselves by selecting a " +
                "\nrandom heading and random steps, then moving in that direction";

        return cmmds;
    }
}

public class RandomWalkSimulation extends Simulation {

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++)
            addAgent(new Drunk());
    }

    public void stats() {
        JFrame frame = new JFrame("Random Walks Stats");
        JOptionPane.showMessageDialog(frame, "Number of agents = " + NUM_OF_AGENTS
                + "\n clock = " + clock);
    }


    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }


}
