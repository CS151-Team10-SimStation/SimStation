package flocking;

import mvc.Model;
import simstation.SimulationFactory;

/* Revision History
4/16/21: Samantha updated FlockingSFactory
 */
public class FlockingFactory extends SimulationFactory {
    public Model makeModel() {return new FlockingSimulation();}

    public FlockingFactory() { new FlockingSimulation(); }

    @Override
    public String getTitle() { return "Flocking"; }

    @Override
    public String[] getHelp() {
        String[] cmmds = new String[6];
        cmmds[0] = "Start: start simulation";
        cmmds[1] = "Suspend: suspend or pause simulation";
        cmmds[2] = "Resume: resume simulation after suspending";
        cmmds[3] = "Stop: stops simulation";
        cmmds[4] = "Stats: view stats about the agents in the simulation";
        cmmds[5] = "\nEach agent is a bird with a heading and speed. When a bird " +
                "\ncomes in contact with a neighbor, it copies its neighbor's speed";

        return cmmds;
    }
}
