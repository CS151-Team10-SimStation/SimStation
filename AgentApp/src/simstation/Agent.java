package simstation;

import mvc.Utilities;

import java.io.Serializable;

// Revision History:
// 4/16/21: Paul updated Agent class.
//          Added start(), move(), proximity(), setWorld().

abstract public class Agent implements Runnable, Serializable {
    protected Thread myThread; // Thread of the Agent.
    private boolean suspended, stopped; // Used for synchronization.
    protected Simulation world; // The world/manager of the Agent.
    protected int xc, yc; // Agent x- and y-coordinates.
    protected Heading heading; // Agent heading.

    // Constructor
    public Agent() {
        // Initialize instances.
        suspended = false;
        stopped = false;
        myThread = null;
        // Set random location within the size of the World.
        xc = Utilities.rng.nextInt(world.SIZE);
        yc = Utilities.rng.nextInt(world.SIZE);
    }

    // thread stuff:
    public synchronized void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized boolean isSuspended() {
        return suspended;
    }

    public synchronized void resume() {
        notify();
    }

    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch (InterruptedException e) {
            Utilities.error(e);
        }
    }

    private synchronized void checkSuspended() {
        try {
            while (!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            Utilities.error(e);
        }
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(200);
                checkSuspended();
            } catch (InterruptedException e) {
                Utilities.error(e);
            }
        }
    }

    // To be overridden by customizations.
    public abstract void update();

    // Move method. Can be overridden.
    public void move(int step) {
        if (heading == Heading.NORTH) yc -= step;
        if (heading == Heading.SOUTH) yc += step;
        if (heading == Heading.WEST) xc -= step;
        if (heading == Heading.EAST) xc += step;
        world.changed();
    }

    // Helper method for distance between two agents.
    public double proximity(Agent a) {
        // Use distance formula.
        double xsquared = (Math.abs(a.xc - this.xc)) * (Math.abs(a.xc - this.xc));
        double ysquared = (Math.abs(a.yc - this.yc)) * (Math.abs(a.yc - this.yc));
        return Math.sqrt(xsquared + ysquared);
    }

    //Set new Simulation.
    public void setWorld(Simulation newWorld) {
        world = newWorld;
    }
}
