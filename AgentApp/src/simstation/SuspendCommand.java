package simstation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {
    public SuspendCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        System.out.println("Suspend Command executed."); // To debug
        Simulation s = (Simulation) model;
        s.suspend();
    }
    //stop temporarily
}
