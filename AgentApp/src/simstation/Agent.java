package simstation;

import mvc.Utilities;

import java.io.Serializable;

// 4/16/21: Paul updated Agent class.
//          Added start().
abstract public class Agent implements Runnable, Serializable {
    // protected String name;
    protected Thread myThread;
    private boolean suspended, stopped;
    protected Simulation world;
    protected int xc, yc;
    protected Heading heading;

    public Agent() {
        // this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;
        xc = Utilities.rng.nextInt(world.SIZE);
        yc = Utilities.rng.nextInt(world.SIZE);
    }

//    public void setManager(Manager m) { manager = m; }
//    public String getName() { return name; }
//    public synchronized String toString() {
//        String result = name;
//        if (stopped) result += " (stopped)";
//        else if (suspended) result += " (suspended)";
//        else result += " (running)";
//        return result;
//    }

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
                Thread.sleep(1000);
                checkSuspended();
            } catch (InterruptedException e) {
                Utilities.error(e);
            }
        }
//        manager.stdout.println(name + " stopped");
    }

    // To be overridden by customizations.
    public abstract void update();

    public void move(int step) {
        int oldXc = xc;
        int oldYc = yc;
        if (heading == Heading.NORTH) yc -= step;
        if (heading == Heading.SOUTH) yc += step;
        if (heading == Heading.WEST) xc -= step;
        if (heading == Heading.EAST) xc += step;
        world.changed("xComp", oldXc, xc);
        world.changed("yComp", oldYc, yc);
        System.out.printf("Drunk has moved %d steps %s %n", step, heading.toString());
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
