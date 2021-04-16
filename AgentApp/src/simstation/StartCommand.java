package simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        System.out.println("Start Command executed."); // To debug
        Simulation s = (Simulation) model;
        s.start();
    }
    //populate view with Agents
}
