package plague;

import mvc.*;
import simstation.*;

import javax.swing.*;
import java.text.DecimalFormat;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50;   // % chance of infection
    public static int RESISTANCE = 2;   // % chance of resisting infection
    public static int INITIAL_INFECTION_PERCENT = 10;   //initial infection rate
    public PlagueSimulation() { super(); }

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++) {
            addAgent(new People());
        }
    }

    public void stats() {
        DecimalFormat formatter = new DecimalFormat("##.##");   // formatting the percentages
        double infections = 0;
        for(Agent a : this.getAgentList()) {
            if (((People) a).getInfected() == true) {
                infections++;
            }
        }

        JFrame frame = new JFrame("Plague Stats");
        JOptionPane.showMessageDialog(frame, "Number of People: " +
                this.getAgentList().size() +
                "\n% infected: " +
                formatter.format((infections/this.getAgentList().size()) * 100) +
                "\nClock: " + clock);
    }

    public static void main(String[] args) {
        PlagueFactory plague = new PlagueFactory();
        AppPanel panel = new SimulationPanel(plague);
        panel.display();

    }
}
