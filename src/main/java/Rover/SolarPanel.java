package Rover;

import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.RandomMaker;

public class SolarPanel {
    private boolean isFolded = true;
    private BatteryManagement batteryManagement;

    public void fold() {
        isFolded = false;
    }

    public void unfold() {
        isFolded = true;
    }

    public void collect() {
        if (!isFolded) {
            int[] randomInts = RandomMaker.getRandomIntArray(0, 1, 1000);
            int count = 0;
            for (int randomInt : randomInts) {
                if (randomInt == 1) count++;
            }
            batteryManagement.charge(count);
        } else {
            ConsoleLogger.log("Solar Panel must be unfolded first!");
        }
    }
}
