package Rover;

import Enums.MotorDirection;

public class ElectricMotor {
    private MotorDirection direction;

    public ElectricMotor() {
    }

    public void moveForward(int energyAmount){
        direction = MotorDirection.FORWARD;

    }

    public void moveBackwards(int energyAmount){
        direction = MotorDirection.BACKWARD;

    }
}
