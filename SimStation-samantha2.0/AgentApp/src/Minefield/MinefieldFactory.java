package Minefield;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

import java.io.Serializable;

public class MinefieldFactory implements AppFactory, Serializable {
    public Model makeModel() {
        return new Minefield();
    }

    public View makeView(Model m) {
        return new MinefieldView((Minefield) m);
    }

    public String getTitle() {
        return "Minefield";
    }

    public String[] getEditCommands() {
        return new String[]{"N", "E", "W", "S", "NE", "NW", "SE", "SW"};
    }

    public Command makeEditCommand(Model model, String cmmd) {
        switch (cmmd) {
            case "N": {
                return new MoveCommand(model, "N");
            }
            case "E": {
                return new MoveCommand(model, "E");
            }
            case "W": {
                return new MoveCommand(model, "W");
            }
            case "S": {
                return new MoveCommand(model, "S");
            }
            case "NE": {
                return new MoveCommand(model, "NE");
            }
            case "NW": {
                return new MoveCommand(model, "NW");
            }
            case "SE": {
                return new MoveCommand(model, "SE");
            }
            case "SW": {
                return new MoveCommand(model, "SW");
            }
        }
        return null;
    }

    //Set the Help and About messages below.
    public String[] getHelp() {
        return new String[]{
                "You are a minesweeper starting at the top left square, \n" +
                        "your goal is to make it to the bottom right square, while \n" +
                        "avoiding mines on the field. \n \n" +

                        "You can move around the field in the 8 cardinal and \n" +
                        "intermediate directions. Each press of a button will move \n" +
                        "you only one square at a time \n \n" +

                        "The number displayed in each tile indicates the number of \n" +
                        "mines in each adjacent tile. If you move onto a tile with \n" +
                        "a mine the game is over. \n \n" +

                        "Note: You cannot move off of the grid or wrap around the field."};
    }

    public String about() {
        return "Minefield version 1.0. Copyright 2021 by SGSZRP Designs";
    }
}
