package Rover;

import Enums.Manufacturer;

import java.lang.reflect.Array;

public class Battery {
    private Manufacturer manufacturer;
    private final int maximumCapacity = 50000;
    private float percentageFull = 0f;
    private final BatteryCell[] cells = new BatteryCell[5];

    public Battery() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new BatteryCell();
        }
    }

    public float getPercentageFull() {
        float percentage = 0f;
        for (BatteryCell cell : cells) {
            percentage += cell.getPercentageFull() / cells.length;
        }
        percentageFull = percentage;
        return percentageFull;
    }

    public BatteryCell[] getBatteryCells(){
        return cells;
    }
}
