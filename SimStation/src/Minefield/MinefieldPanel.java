package Minefield;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Controller: executes user commands by updating the model
public class MinefieldPanel extends AppPanel {

    //Define how many buttons you would like on the button panel here.
    private JButton N,
            E,
            W,
            S,
            NE,
            NW,
            SE,
            SW,
            space;

    public MinefieldPanel(AppFactory factory) {
        super(factory);

        //Create buttons for the button panel
        N = new JButton("N");
        E = new JButton("E");
        W = new JButton("W");
        S = new JButton("S");
        NE = new JButton("NE");
        NW = new JButton("NW");
        SE = new JButton("SE");
        SW = new JButton("SW");
        space = new JButton(" ");   // non-functional spacer to align buttons

        //Add action listeners to buttons in the factory.
        N.addActionListener(this);
        E.addActionListener(this);
        W.addActionListener(this);
        S.addActionListener(this);
        NE.addActionListener(this);
        NW.addActionListener(this);
        SE.addActionListener(this);
        SW.addActionListener(this);



        //Add the newly created buttons to the Button Panel.
        controlPanel.setLayout(new GridLayout(3, 3));
        controlPanel.add(NW);
        controlPanel.add(N);
        controlPanel.add(NE);
        controlPanel.add(W);
        controlPanel.add(space);
        controlPanel.add(E);
        controlPanel.add(SW);
        controlPanel.add(S);
        controlPanel.add(SE);



    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }
}
