package simstation;
/* EDITS
samantha (4/16) -- modified getHelp
 */
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

import java.io.Serializable;
/* History
4/16/21: Samantha updated SimulationFactory; added getters and setters to sim
 */
public class SimulationFactory implements AppFactory, Serializable {
    private Simulation sim = new Simulation();

    @Override
    public Model makeModel() {return sim;}

    public Simulation getSim() { return this.sim; }
    public void setSim(Simulation sim) { this.sim = sim; }

    @Override
    public View makeView(Model m) {
        return new SimulationView(m);
    }
    public View getView(Model m) { return new SimulationView(sim); }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String cmmd) {
        if (cmmd.equals("Start")) return new StartCommand(model);
        if (cmmd.equals("Stop")) return new StopCommand(model);
        if (cmmd.equals("Suspend")) return new SuspendCommand(model);
        if (cmmd.equals("Resume")) return new ResumeCommand(model);
        if (cmmd.equals("Stats")) return new StatsCommand(model);
        return null;
    }


    //will override for each different simulation
    @Override
    public String[] getHelp() {
        String[] commands = new String[6];
//        commands[0] = "Start: Start the simulation.";
//        commands[1] = "Stop: Stop the simulation.";
//        commands[2] = "Suspend: Pause the simulation.";
//        commands[3] = "Resume: Resume the simulation.";
//        commands[4] = "Stats: Get simulation stats.";
//        commands[5] = "info about specific simulation will go here";
        return commands;
    }

    @Override
    public String about() {
        return "SimStation version 1.0. Copyright 2021 by Junsheng, Paul, and Samantha";
    }
}
