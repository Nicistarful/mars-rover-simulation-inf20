package Rover;

import Enums.Direction;

public class Suspension {
    private Direction direction;
    private Wheel wheel;

    public Suspension() {
        direction = Direction.STRAIGHT;
    }

    public void alignStraight() {
        this.direction = Direction.STRAIGHT;
    }

    public void alignLeft() {
        this.direction = Direction.LEFT;
    }

    public void alignRight() {
        this.direction = Direction.RIGHT;
    }

    public Wheel getWheel() {
        return wheel;
    }
}
