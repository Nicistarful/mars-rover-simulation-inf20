package Rover;

import CameraEquipment.*;
import Interfaces.ICamera;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Camera implements ICamera {
    private final String serialNumber = "Z7B98N50";
    private Lens lens;
    private MemoryCard memoryCard;
    private int currentFactor = 0;
    private ArrayList<Filter> filters;
    private ArrayList<IRLED> irleds;
    private ArrayList<Chip> chips;
    private MarsRover rover;

    public Camera(Lens lens, MemoryCard memoryCard, ArrayList<Filter> filters, ArrayList<IRLED> irleds, ArrayList<Chip> chips) {
        this.lens = lens;
        this.memoryCard = memoryCard;
        this.filters = filters;
        this.irleds = irleds;
        this.chips = chips;
    }

    public int getCurrentFactor() {
        return currentFactor;
    }

    public void setCurrentFactor(int currentFactor) {
        if (currentFactor > 2 || currentFactor < 0) {
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
        Picture picture = new Picture(LocalDateTime.now().getNano(), rover.getCurrentPosition());
        return picture;
    }

    public void setRover(MarsRover rover) {
        this.rover = rover;
    }
}
