package simstation;

import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command {
    public ResumeCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        System.out.println("Resume Command executed."); // To debug
        Simulation s = (Simulation) model;
        s.resume();
    }
    //resume program
}
