package Minefield;

import mvc.Bean;

public class Grid extends Bean {
    private int X;                   // col position
    private int Y;                   // row position
    private Minefield minefield;
    private boolean isMined;         // is this grid mined?
    private int nearbyMines;         // # of nearby mines
    private boolean isWinningSquare; // is this winning square?
    private boolean isExposed;       // is this square exposed?

    public Grid(Minefield minefield, int row, int col, boolean isMined) {
        this.minefield = minefield;
        this.Y = row;
        this.X = col;
        this.isMined = isMined;
        nearbyMines = -1;
        if (Y == 19 && X == 19) {       // Sets winning square at end of board
            isWinningSquare = true;
        } else {
            isWinningSquare = false;
        }
        isExposed = false;
    }

    public boolean getIsWinningSquare() {
        return isWinningSquare;
    }

    public void setIsExposed(boolean bool) {
        isExposed = bool;
    }

    public boolean isExposed() {
        return isExposed;
    }

    // Calculates the number of nearby mines
    public int calcNearbyMines() {
        nearbyMines = 0;
        if (Y - 1 >= 0) { // N
            if (minefield.getGrid(X, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19) { // S
            if (minefield.getGrid(X, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        if (X - 1 >= 0) { // W
            if (minefield.getGrid(X - 1, Y).isMined) {
                nearbyMines++;
            }
        }
        if (X + 1 <= 19) { // E
            if (minefield.getGrid(X + 1, Y).isMined) {
                nearbyMines++;
            }
        }
        if (Y - 1 >= 0 && X - 1 >= 0) { //NW
            if (minefield.getGrid(X - 1, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y - 1 >= 0 && X + 1 <= 19) { // NE
            if (minefield.getGrid(X + 1, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19 && X - 1 >= 0) { //SW
            if (minefield.getGrid(X - 1, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19 && X + 1 <= 19) { // SE
            if (minefield.getGrid(X + 1, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        return nearbyMines;
    }

    // Setter methods
    public void setIsMined(boolean bool) {
        isMined = bool;
    }

    // Helper methods
    public boolean isMined() {
        return isMined;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public int getNearbyMines() {
        return nearbyMines;
    }

}
