package simstation;

import mvc.Command;
import mvc.Model;

// Revision History:
// 4/16/21: Paul updated StopCommand class.
public class StopCommand extends Command {
    public StopCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        System.out.println("Stop Command executed."); // To debug
        Simulation s = (Simulation) model;
        s.stop();
    }
    //stop altogether
}
