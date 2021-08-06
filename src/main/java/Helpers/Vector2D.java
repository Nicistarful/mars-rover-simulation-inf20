package Helpers;

import java.util.Objects;

public class Vector2D {
    private int xPos;

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    private int yPos;

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }


    public Vector2D(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void add(Vector2D v) {
        this.xPos += v.getxPos();
        this.yPos += v.getyPos();
    }

    public void multiply(Vector2D v) {
        this.xPos *= v.getxPos();
        this.yPos *= v.getyPos();
    }

    @Override
    public String toString() {
        return "(X: %d | Y: %d)".formatted(xPos, yPos);
    }

}
