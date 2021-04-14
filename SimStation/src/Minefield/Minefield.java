package Minefield;

import mvc.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Minefield extends Model {

    public static final int gridSize = 20;  // Size of grid

    private Grid[][] board;             // Represents the game board filled with mines
    private Point currentLocation;      // Represents current location of sergent
    private boolean gameOver;           // Is game over?

    public Minefield() {
        gameOver = false;               // Set game over to false
        // Initialize board
        board = new Grid[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = new Grid(this, i, j, false);
            }
        }
        // Fills the board randomly with mines
        Random gen = new Random();      // Random number generator to generate mines
        int count = 0;
        int row;
        int col;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // If amount of mines is less than 20 (5% of board), random
                // number generated is not the first or last space, and
                // the space is not already mined, increase count and place a mine
                // in that space.
                if (count < 20 && !(i == 0 && j == 0) && !(i == 19 && j == 19)) {
                    row = gen.nextInt(20);
                    col = gen.nextInt(20);
                    if (!board[i][j].isMined()) {
                        board[row][col].setIsMined(true);
                        count++;
                    }
                } else {
                    // Break loop to save time
                    break;
                }
            }
        }
        // Set current location to first grid, set that grid to exposed
        board[0][0].setIsExposed(true);
        currentLocation = new Point(0, 0);
    }

    public void nw() throws Exception {
        if (!gameOver) {                                // If game is over, throw exception
            int oldx = currentLocation.getXCord();
            int oldy = currentLocation.getYCord();
            if (oldy - 1 >= 0 && oldx - 1 >= 0) {       // Check if movement is in bounds of board, if not throw exception
                currentLocation.setXCord(oldx - 1);     // Set current location to new location
                currentLocation.setYCord(oldy - 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);   // expose square
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {     // Check for mines
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");                     // throw exception
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {      // Check if this position
                    gameOver = true;                                                                // is winning grid, if so
                    throw new Exception("Game Over: You've won!");                                  // throw exception, game over
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void n() throws Exception {
        if (!gameOver) {
            int oldy = currentLocation.getYCord();
            if (oldy - 1 >= 0) {
                currentLocation.setYCord(oldy - 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void ne() throws Exception {
        if (!gameOver) {
            int oldx = currentLocation.getXCord();
            int oldy = currentLocation.getYCord();
            if (oldy - 1 >= 0 && oldx + 1 <= 19) {
                currentLocation.setXCord(oldx + 1);
                currentLocation.setYCord(oldy - 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void w() throws Exception {
        if (!gameOver) {
            int oldx = currentLocation.getXCord();
            if (oldx - 1 >= 0) {
                currentLocation.setXCord(oldx - 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void e() throws Exception {
        if (!gameOver) {
            int oldx = currentLocation.getXCord();
            if (oldx + 1 <= 19) {
                currentLocation.setXCord(oldx + 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void sw() throws Exception {
        if (!gameOver) {
            int oldx = currentLocation.getXCord();
            int oldy = currentLocation.getYCord();
            if (oldy + 1 <= 19 && oldx - 1 >= 0) {
                currentLocation.setXCord(oldx - 1);
                currentLocation.setYCord(oldy + 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void s() throws Exception {
        if (!gameOver) {
            int oldy = currentLocation.getYCord();
            if (oldy + 1 <= 19) {
                currentLocation.setYCord(oldy + 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }

    public void se() throws Exception {
        if (!gameOver) {
            int oldx = currentLocation.getXCord();
            int oldy = currentLocation.getYCord();
            if (oldy + 1 <= 19 && oldx + 1 <= 19) {
                currentLocation.setXCord(oldx + 1);
                currentLocation.setYCord(oldy + 1);
                board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
                if (isThisSpaceMined(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've stepped on a mine");
                }
                if (isWinningSquare(currentLocation.getXCord(), currentLocation.getYCord())) {
                    gameOver = true;
                    throw new Exception("Game Over: You've won!");
                }
            } else {
                throw new Exception("Do not move out of bounds");
            }
        } else {
            throw new Exception("Game is over");
        }
        firePropertyChange(null, null, null);
    }



    // Helper methods
    public Grid getGrid(int row, int col) {
        return board[row][col];
    }

    public Grid[][] getBoard() {
        return board;
    }

    public boolean getBoardIsExposed(int x, int y) {
        return board[x][y].isExposed();
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public int getNearbyMines(int x, int y) {
        return board[x][y].calcNearbyMines();
    }

    public boolean isThisSpaceMined(int x, int y) {
        return board[x][y].isMined();
    }

    public boolean isWinningSquare(int x, int y) {
        return board[x][y].getIsWinningSquare();
    }

    public boolean getIsGameOver() {
        return gameOver;
    }
}
