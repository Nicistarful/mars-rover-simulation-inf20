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

    public ArrayList<Battery> getBatteryReferences() {
        return batteryReferences;
    }

    public Battery charge(int amount) {
        Battery b = getRandomBattery();
        BatteryCell[] cells = b.getBatteryCells();
        for (BatteryCell cell : cells) {
            cell.charge(amount);
        }
        return b;
    }

    private Battery getRandomBattery() {
        return batteryReferences.get(new Random().nextInt(4));
    }

    public void charge(int index, int amount) {
        BatteryCell[] cells = batteryReferences.get(index).getBatteryCells();
        for (BatteryCell cell : cells) {
            cell.charge(amount);
        }
    }

    public void discharge(int amount) {
        Battery b = getRandomBattery();
        BatteryCell[] cells = b.getBatteryCells();
        for (BatteryCell cell : cells) {
            cell.discharge(amount);
        }
    }

    public float getPowerLevel(){
        float percentage = 0f;
        ArrayList<Battery> batteries = batteryReferences;
        for (Battery battery : batteries) {
            ConsoleLogger.log(battery.getPercentageFull());
            percentage += (battery.getPercentageFull() / batteryReferences.size());
        }
        return percentage;
    }
}
