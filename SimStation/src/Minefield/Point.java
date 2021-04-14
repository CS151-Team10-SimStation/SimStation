package Minefield;

import mvc.Bean;

public class Point extends Bean {
    private int XCord;
    private int YCord;

    public Point(int x, int y) {
        XCord = x;
        YCord = y;
    }

    public void setXCord(int XCord) {
        this.XCord = XCord;
    }

    public void setYCord(int YCord) {
        this.YCord = YCord;
    }

    public int getYCord() {
        return YCord;
    }

    public int getXCord() {
        return XCord;
    }
}
