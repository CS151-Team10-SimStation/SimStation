package simstation;
import mvc.*;

import java.io.Serializable;

public class SimulationFactory implements AppFactory, Serializable {
    public Model makeModel() {return new Simulation();}

    public View makeView(Model m) {return new SimulationView((Simulation) m);};

    public String getTitle() {return "SimStation";}

    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }


    public Command makeEditCommand(Model model, String cmmd) {
//        switch (cmmd) {
//            case "Start": {
//                return new StartCommand();
//            }
//            case "Suspend": {
//                return new SuspendCommand();
//            }
//            case "Resume": {
//                return new ResumeCommand();
//            }
//            case "Stop": {
//                return new StopCommand();
//            }
//            case "Stats": {
//                return new StatsCommand();
//            }
//        }
        return null;
    }

    public String[] getHelp() {
        return new String[]{
                "Info about SimStation (update later)"};
    }

    public String about() {
        return "SimStation version 1.0. Copyright 2021 by Junsheng, Paul, and Samantha";
    }
}
