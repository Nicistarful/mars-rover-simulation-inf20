package Rover;

import Utility.BatteryManagement;

import java.util.ArrayList;

public class Chassis {
    private ArrayList<Suspension> suspensions = new ArrayList<>();
    private BatteryManagement batteryManagement;

    public Chassis(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        for (int i = 0; i < 6; i++) {
            suspensions.add(new Suspension(this.batteryManagement));
        }
    }

    public ArrayList<Suspension> getSuspensions() {
        return suspensions;
    }
}
