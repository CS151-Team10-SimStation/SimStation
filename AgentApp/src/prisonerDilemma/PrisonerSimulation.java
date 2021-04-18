package prisonerDilemma;

import mvc.AppPanel;
import mvc.Model;
import simstation.Simulation;
import simstation.SimulationFactory;
import simstation.SimulationPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class PrisonerFactory extends SimulationFactory {
    public Model makeModel() {
        return new PrisonerSimulation();
    }

    public String getTitle() {
        return "Prisoner's Dilemma";
    }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[6];
        cmmds[0] = "Start: starts the simulation";
        cmmds[1] = "Stop: stops the simulation";
        cmmds[2] = "Suspend: temporarily stops/suspends the simulation";
        cmmds[3] = "Resume: resumes the simulation";
        cmmds[4] = "Stats: lists stats of the simulation";
        cmmds[5] = "\n Prisoners are represented by dots. \n they play a game of Prisoner's Dilemma with the nearest neighbor. ";
        return cmmds;
    }
}
public class PrisonerSimulation extends Simulation {
    // Keep track of how prisoners are using each DecisionStrategy.
    List<Prisoner> cooperators = new ArrayList<>();
    List<Prisoner> cheaters = new ArrayList<>();
    List<Prisoner> randomCooperators = new ArrayList<>();
    List<Prisoner> titfortaters = new ArrayList<>();

    public void populate() {
        for (int i = 4; i < NUM_OF_AGENTS + 4; i++) {
            Prisoner p = new Prisoner();
            // Spread strategies evenly (1/4 of agents)
            if(i % 4 == 0) {
                p.setStrategy(new Cooperate(p));
                cooperators.add(p);
            }
            if(i % 4 == 1) {
                p.setStrategy(new Cheat(p));
                cheaters.add(p);
            }
            if(i % 4 == 2) {
                p.setStrategy(new RandomlyCooperate(p));
                randomCooperators.add(p);
            }
            if(i % 4 == 3) {
                p.setStrategy(new TitForTat(p));
                titfortaters.add(p);
            }
            addAgent(p);
        }
    }

    public void stats() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, getPanel(), "Prisoner Stats : ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    //create separate JPanel to add to stats JFrame
    private JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel sp1 = new JLabel ("Average fitness for cooperators = " + averageFitness(cooperators));
        JLabel sp2 = new JLabel ("Average fitness for cheaters = " + averageFitness(cheaters));
        JLabel sp3 = new JLabel ("Average fitness for random cooperators = " + averageFitness(randomCooperators));
        JLabel sp4 = new JLabel("Average fitness for tit for tat-ers = " + averageFitness(titfortaters));

        panel.add(sp1);
        panel.add(sp2);
        panel.add(sp3);
        panel.add(sp4);

        return panel;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }

    // Private method to calculate average fitness
    private int averageFitness(List<Prisoner> prison){
        int fitnessSum = 0;
        for (Prisoner p: prison) { fitnessSum += p.getFitness();}
        return fitnessSum / prison.size();
    }

}
