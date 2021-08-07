package Utility;

import Rover.Battery;
import Rover.BatteryCell;

import java.util.ArrayList;
import java.util.Random;

public class BatteryManagement {
    ArrayList<Battery> batteryReferences;

    public BatteryManagement(ArrayList<Battery> batteryReferences) {
        this.batteryReferences = batteryReferences;
    }

    public void charge(int amount) {
        BatteryCell[] cells = getRandomBatteryCells();
        for (BatteryCell cell : cells) {
            cell.charge(amount);
        }
    }

    private BatteryCell[] getRandomBatteryCells() {
        return batteryReferences.get(new Random().nextInt(4)).getBatteryCells();
    }

    public void charge(int index, int amount) {
        BatteryCell[] cells = batteryReferences.get(index).getBatteryCells();
        for (BatteryCell cell : cells) {
            cell.charge(amount);
        }
    }

    public void discharge(int amount) {
        BatteryCell[] cells = getRandomBatteryCells();
        for (BatteryCell cell : cells) {
            cell.discharge(amount);
        }
    }
}
