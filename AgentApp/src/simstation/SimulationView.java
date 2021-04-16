package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.beans.PropertyChangeEvent;

public class SimulationView extends View {
    private int agentSize = 10;
    private Simulation world;

    public SimulationView(Model model) {
        super(model);
        world = (Simulation) model;
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        for (Agent a : world.agents) {
            gc.setColor(Color.WHITE);
            gc.fillOval(a.xc, a.yc, agentSize, agentSize);
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        int x = 0, y = 0;
        boolean xIsChanged = false, yisChanged = false;
        if (evt.getPropertyName().equals("xComp")) {
            x = (Integer) evt.getNewValue();
            xIsChanged = true;
        }
        if (evt.getPropertyName().equals("yComp")) {
            y = (Integer) evt.getNewValue();
            yisChanged = true;
        }
        if (xIsChanged && yisChanged) {
            repaint(x, y, agentSize, agentSize);
        }
    }

}
