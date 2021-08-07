package Rover;

import Enums.MotorDirection;
import Utility.BatteryManagement;

public class ElectricMotor {
    private MotorDirection direction;
    private BatteryManagement batteryManagement;

    public ElectricMotor(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
    }

    public void moveForward(int energyAmount){
        direction = MotorDirection.FORWARD;
        batteryManagement.discharge(energyAmount);
    }

    public void moveBackwards(int energyAmount){
        direction = MotorDirection.BACKWARD;
        batteryManagement.discharge(energyAmount);
    }
}
