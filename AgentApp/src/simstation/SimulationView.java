package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.beans.PropertyChangeEvent;

// Revision History:
// 4/16/21: Paul updated SimulationView class.
//          Added paintComponent(), propertyChange().
// 4/16/21: Samantha made AGENTSIZE protected instead of private
public class SimulationView extends View {
    protected final int AGENTSIZE = 5;

    public SimulationView(Model model) {
        super(model);

    }

    // Draw a white oval of diameter AGENTSIZE for each agent.
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation world = (Simulation) model;
        for (Agent a : world.agents) {
            gc.setColor(Color.WHITE);
            gc.fillOval(a.xc, a.yc, AGENTSIZE, AGENTSIZE);
        }
    }

    // Update view every time an Agent run().
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
