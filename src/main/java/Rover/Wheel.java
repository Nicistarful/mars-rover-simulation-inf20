package Rover;

import Utility.BatteryManagement;

public class Wheel {
    private ElectricMotor electricMotor;
    private BatteryManagement batteryManagement;

    public Wheel(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        electricMotor  = new ElectricMotor(batteryManagement);
    }

    public ElectricMotor getElectricMotor() {
        return electricMotor;
    }
}
