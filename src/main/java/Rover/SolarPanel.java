package Rover;

import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.RandomMaker;

import java.util.ArrayList;

public class SolarPanel {
    private boolean isFolded = true;
    private BatteryManagement batteryManagement;

    public SolarPanel(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
    }

    public void fold() {
        isFolded = true;
    }

    public void unfold() {
        isFolded = false;
    }

    public void collect() {
        if (isFolded) {
            ConsoleLogger.log("Solar Panel must be unfolded first!");
            return;
        }
        ArrayList<Battery> batteries = batteryManagement.getBatteryReferences();
        while (batteryManagement.getPowerLevel() < 75f) {
            int[] randomInts = RandomMaker.getRandomIntArray(0, 1, 1000);
            int count = 0;
            for (int randomInt : randomInts) {
                if (randomInt == 1) count++;
            }
            batteryManagement.charge(count);
        }
    }
}
