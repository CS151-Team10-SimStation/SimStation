package simstation;

import mvc.Command;
import mvc.Model;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        System.out.println("Stats Command executed."); // To debug
        Simulation s = (Simulation) model;
        s.stats();
    }
    //display current state
}
