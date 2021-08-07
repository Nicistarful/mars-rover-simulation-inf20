package Utility;

import Rover.Suspension;

import java.util.ArrayList;

public class MovementManagement {
    private ArrayList<Suspension> suspensionReferences;

    public MovementManagement(ArrayList<Suspension> suspensionReferences) {
        this.suspensionReferences = suspensionReferences;
    }

    public void moveUp() {
        suspensionReferences.forEach(suspension -> {
            suspension.alignStraight();
            suspension.getWheel().getElectricMotor().moveForward(5);
        });
    }

    public void moveDown() {
        suspensionReferences.forEach(suspension -> {
            suspension.alignStraight();
            suspension.getWheel().getElectricMotor().moveBackwards(5);
        });
    }

    public void turnLeft() {
        suspensionReferences.forEach(suspension -> {
            suspension.alignLeft();
            suspension.getWheel().getElectricMotor().moveForward(5);
        });
    }

    public void turnRight() {
        suspensionReferences.forEach(suspension -> {
            suspension.alignRight();
            suspension.getWheel().getElectricMotor().moveForward(5);
        });
    }
}
