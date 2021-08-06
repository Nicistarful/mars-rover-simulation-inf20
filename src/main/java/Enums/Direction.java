package Enums;

public enum Direction {
    STRAIGHT ("straight"),
    LEFT ("left"),
    RIGHT ("right");

    private final String direction;

    Direction(String s) {
        direction = s;
    }

    @Override
    public String toString() {
        return this.direction;
    }
}
