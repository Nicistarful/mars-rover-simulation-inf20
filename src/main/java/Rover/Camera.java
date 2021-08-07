package Rover;

import CameraEquipment.*;
import Interfaces.ICamera;

import java.util.ArrayList;

public class Camera implements ICamera {
    private final String serialNumber = "Z7B98N50";
    private int currentFactor = 0;
    private final Lens lens = new Lens(this);
    private ArrayList<Filter> filters;
    private ArrayList<IRLED> irleds;
    private ArrayList<Chip> chips;

    public Camera() {
        for (int i = 0; i < 10; i++) {
            if (i < 2) chips.add(new Chip());
            if (i < 3) filters.add(new Filter(this));
            irleds.add(new IRLED());
        }
    }

    private final MemoryCard memoryCard = new MemoryCard(this);

    public int getCurrentFactor() {
        return currentFactor;
    }

    public void setCurrentFactor(int currentFactor) {
        if (currentFactor > 2 || currentFactor < 0){
            this.currentFactor = 0;
        } else {
            this.currentFactor = currentFactor;
        }
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void zoomIn() {
        setCurrentFactor(currentFactor++);
    }

    @Override
    public void zoomOut() {
        setCurrentFactor(currentFactor--);
    }

    @Override
    public Picture takePicture() {
        return null;
    }
}
