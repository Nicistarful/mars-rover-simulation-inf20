package Helpers;

public record Vector2D(int x, int y) {
    private static int xPos;
    private static int yPos;

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        Vector2D.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        Vector2D.yPos = yPos;
    }

    public Vector2D {
        xPos = x;
        yPos = y;
    }

    public void add(Vector2D v) {
        xPos += v.getxPos();
        yPos += v.getyPos();
    }

    public void multiply(Vector2D v){
        xPos *= v.getxPos();
        yPos *= v.getyPos();
    }
}
