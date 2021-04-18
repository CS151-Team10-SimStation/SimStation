package flocking;

import mvc.*;
import simstation.*;

import javax.swing.*;
import java.awt.*;

/* Revision History
4/16/21: Samantha updated FlockingSimulation; added populate(), stats(), getPanel()
 */

public class FlockingSimulation extends Simulation {
    public FlockingSimulation() {
        super();
    }

    public void populate() {
        for (int i = 0; i < NUM_OF_AGENTS; i++){
            addAgent(new Birds());
        }
    }

    public void stats() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, getPanel(), "Flocking Stats : ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    //create separate JPanel to add to stats JFrame
    private JPanel getPanel() {
        //keeps track of num how many agents are travelling at each speed
        int speed1 = 0;
        int speed2 = 0;
        int speed3 = 0;
        int speed4 = 0;
        int speed5 = 0;

        //probably a more efficient way of doing this lol
        for(Agent a : agents) {
            if(a.getSpeed() == 1 ) {
                speed1++;
            } else if( a.getSpeed() == 2 ) {
                speed2++;
            } else if(a.getSpeed() == 3 ) {
                speed3++;
            } else if(a.getSpeed() == 4 ) {
                speed4++;
            } else {
                speed5++;
            }
        }

        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel sp1 = new JLabel ("Number of birds at speed 1 = " + speed1 );
        JLabel sp2 = new JLabel ("Number of birds at speed 2 = " + speed2 );
        JLabel sp3 = new JLabel ("Number of birds at speed 3 = " + speed3 );
        JLabel sp4 = new JLabel("Number of birds at speed 4 = " + speed4 );
        JLabel sp5 = new JLabel("Number of birds at speed 5 = " + speed5 );

        panel.add(sp1);
        panel.add(sp2);
        panel.add(sp3);
        panel.add(sp4);
        panel.add(sp5);

        return panel;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
