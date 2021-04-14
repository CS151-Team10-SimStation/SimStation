package simstation;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import mvc.Model;
import mvc.View;

public class SimulationView extends View{
    public SimulationView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {super.paintComponent(gc);}


}
