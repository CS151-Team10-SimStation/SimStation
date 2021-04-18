package plague;

import simstation.Agent;
import simstation.SimulationView;

import java.awt.*;
import java.beans.PropertyChangeEvent;

public class PlagueView extends SimulationView {
    public PlagueView(PlagueSimulation sim) { super(sim); }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        PlagueSimulation sim = (PlagueSimulation) model;
        for(Agent a : sim.getAgentList()) {
            if(((People)a).getInfected()) {
                gc.setColor(Color.RED);
            } else { gc.setColor(Color.GREEN);}
            gc.fillOval(a.getX_Pos(), a.getY_Pos(), AGENTSIZE,AGENTSIZE );

        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
