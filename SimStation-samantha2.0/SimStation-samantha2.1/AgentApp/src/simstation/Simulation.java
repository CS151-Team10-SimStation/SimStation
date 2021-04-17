package simstation;

import mvc.Model;
import mvc.Utilities;

import java.util.*;

/* Revision History:
4/16/21: Paul updated Simulation class.
         Added getNeighbor(), getSize(), addAgent(), removeAgent(), stats(), changed().
4/16/21: Samantha updated Simulation with set number of agents and changed clock to protected
         Added getAgentList()
 */

public class Simulation extends Model {
    public static final int SIZE = 250; // World size.
    public List<Agent> agents; // List of Agents.
    public Integer NUM_OF_AGENTS= 200; // initialize number of agents

    // Timer stuff (given).
    private Timer timer;
    protected int clock;

    // Constructor.
    public Simulation() {
        agents = new LinkedList<Agent>();
        clock = 0;
    }

    // The Business Layer methods needed.

    // Needs to be overridden by subclasses.
    public void populate() {
    }

    // Get neighbor given an agent and a set radius.
    public synchronized Agent getNeighbor(Agent scout, double radius) {
        Agent neighbor = null;
        boolean foundNeighbor = false;
        int i = Utilities.rng.nextInt(agents.size());
        int start = i;
        while (!foundNeighbor) {
            Agent possible = agents.get(i);
            if (possible != scout && scout.proximity(possible) < radius) {
                neighbor = possible;
                foundNeighbor = true;
            } else {
                i = (i + 1) % agents.size();
                if (i == start) break;
            }
        }
        return neighbor;
    }

    // Start all Agent threads and the Timer.
    public synchronized void start() {
        agents = new LinkedList<Agent>();
        clock = 0;
        populate();
        startTimer();
        for (Agent a : agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
    }

    // Suspend all Agent threads, stop Timer.
    public synchronized void suspend() {
        for (Agent a : agents) {
            a.suspend();
        }
        stopTimer();
    }

    // Resume all Agent threads, start Timer.
    public synchronized void resume() {
        startTimer();
        for (Agent a : agents) {
            a.resume();
        }
    }

    // Stop all Agent threads, stop Timer.
    public synchronized void stop() {
        for (Agent a : agents) {
            a.stop();
        }
        stopTimer();
    }


    // Other necessary methods.

    // Used for StatsCommand.
    public int getSize() {
        return agents.size();
    }

    // Used for populate().
    public synchronized void addAgent(Agent a) {
        agents.add(a);
        a.setWorld(this);
        System.out.printf("New Agent at (%d, %d) %n", a.xc, a.yc);
    }

    // Could be useful??
    public synchronized void removeAgent(Agent a) {
        agents.remove(a);
        a.stop();
    }

    public synchronized Iterator<Agent> iterator() {
        return agents.iterator();
    }

    // Overridden by customizations based on what stats they want to show.
    public void stats() {
        Utilities.inform("Number of agents: " + agents.size());
    }


    // Other changed() method for specific values.
    public void changed(String name, Object oldValue, Object newValue) {
        firePropertyChange(name, oldValue, newValue);
    }

    // The code below is all for Timer stuff.
    //called when start simulation and resume simulation
    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    // called when simulation is paused or stopped.
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            //changed();
        }
    }

    public List<Agent> getAgentList() {
        return agents;
    }

}
