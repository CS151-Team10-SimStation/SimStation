package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {

    private JButton Start,
            Suspend,
            Resume,
            Stop,
            Stats;

    public SimulationPanel(AppFactory factory) {
        super(factory);

        Start = new JButton("Start");
        Suspend = new JButton("Suspend");
        Resume = new JButton("Resume");
        Stop = new JButton("Stop");
        Stats = new JButton("Stats");

        Start.addActionListener(this);
        Suspend.addActionListener(this);
        Resume.addActionListener(this);
        Stop.addActionListener(this);
        Stats.addActionListener(this);

        controlPanel.setLayout(new GridLayout(5, 1));
        controlPanel.add(Start);
        controlPanel.add(Suspend);
        controlPanel.add(Resume);
        controlPanel.add(Stop);
        controlPanel.add(Stats);
    }
    public static void main(String[] args) {
        AppFactory factory = new SimulationFactory();
        AppPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
