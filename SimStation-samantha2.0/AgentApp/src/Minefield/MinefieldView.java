package Minefield;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends mvc.View {

    private Minefield minefield;
    private JLabel[][] board;   // Board of J labels

    // View specifications
    private static final int SIDES = 20;
    private static final int SIDE_LENGTH = 13;
    private static final int GAP = 1;
    private static final Color CELL_COLOR = Color.gray;

    public MinefieldView(Minefield model) {
        super(model);
        minefield = (Minefield) super.model;
        board = new JLabel[SIDES][SIDES];
        // Draw the board below
        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
        setLayout(new GridLayout(SIDES, SIDES));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                if (i == 0 && j == 0) {
                    // First square
                    int nearbyMines = minefield.getNearbyMines(j, i);
                    board[i][j] = new JLabel(String.valueOf(nearbyMines), SwingConstants.CENTER);
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                } else if (i == 19 && j == 19) {
                    // Winning square
                    board[i][j] = new JLabel("?", SwingConstants.CENTER);
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN, GAP));
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                } else {
                    // All other squares
                    board[i][j] = new JLabel("?", SwingConstants.CENTER);

                    // Weird but works w j,i NOT i,j
                    // Un-Comment lines 48-49 and 51 to view mines while playing
//                    if (minefield.isThisSpaceMined(j, i)) {
//                        revealMines(i, j);
//                    } else {
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//                    }
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                }
            }
        }
    }

    public void revealMines(int i, int j) {
        board[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, GAP));
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
    }

    @Override
    // When called, it locates the patch occupied by the player,
    // and modifies the label, border, and/or background color of the
    // corresponding JLabel.
    public void propertyChange(PropertyChangeEvent evt) {

        // Gets current location
        Point newP = minefield.getCurrentLocation();
        // Gets x and y positions
        int y = newP.getXCord();
        int x = newP.getYCord();
        // Get # of nearby mines for JLabel
        int nearbyMines = minefield.getNearbyMines(x, y);
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        // Modifies the J label
        board[x][y].setText(String.valueOf(nearbyMines));
        board[x][y].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
        board[x][y].setBackground(CELL_COLOR);
        board[x][y].setPreferredSize(prefSize);
    }




}
