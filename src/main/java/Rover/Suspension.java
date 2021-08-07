package Rover;

import Enums.Direction;
import Utility.BatteryManagement;

public class Suspension {
    private Direction direction;
    private Wheel wheel;
    private BatteryManagement batteryManagement;

    public Suspension(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        direction = Direction.STRAIGHT;
        wheel = new Wheel(batteryManagement);
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
