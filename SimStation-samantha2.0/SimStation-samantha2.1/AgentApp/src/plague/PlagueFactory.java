package plague;

import mvc.Model;
import mvc.View;

import mvc.*;
import simstation.*;

public class PlagueFactory extends SimulationFactory{

    //So that makeModel can grab the correct simulation
    public PlagueFactory() { setSim(new PlagueSimulation()); }

    @Override
    public Model makeModel() { return getSim(); }

    @Override
    public String getTitle() { return "Plague Simulation"; }

    @Override
    public View getView(Model m) { return new PlagueView((PlagueSimulation)getSim()); }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[7];
        cmmds[0] = "Start: starts the simulation";
        cmmds[1] = "Stop: stops the simulation";
        cmmds[2] = "Suspend: temporarily stops/suspends the simulation";
        cmmds[3] = "Resume: resumes the simulation";
        cmmds[4] = "Stats: lists stats of the simulation";
        cmmds[5] = "Red: infected by the virus";
        cmmds[6] = "Green: uninfected by the virus";

        return cmmds;
    }
}
