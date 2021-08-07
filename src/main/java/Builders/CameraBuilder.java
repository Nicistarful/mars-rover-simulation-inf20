package Builders;

import CameraEquipment.*;
import Rover.Camera;

import java.util.ArrayList;

public class CameraBuilder {
    private Lens lens;
    private MemoryCard memoryCard;
    private ArrayList<Filter> filters;
    private ArrayList<IRLED> irleds;
    private ArrayList<Chip> chips;

    public CameraBuilder setLens(Lens lens) {
        this.lens = lens;
        return this;
    }

    public CameraBuilder setMemoryCard(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
        return this;
    }

    public CameraBuilder setFilters(ArrayList<Filter> filters) {
        this.filters = filters;
        return this;
    }

    public CameraBuilder setIrleds(ArrayList<IRLED> irleds) {
        this.irleds = irleds;
        return this;
    }

    public CameraBuilder setChips(ArrayList<Chip> chips) {
        this.chips = chips;
        return this;
    }

    public Camera createCamera() {
        return new Camera(lens, memoryCard, filters, irleds, chips);
    }
}