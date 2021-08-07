package CameraEquipment;

import Rover.Camera;

import java.util.Stack;

public class MemoryCard {
    private Camera camera;
    private Stack<Picture> storage;

    public MemoryCard(Camera camera) {
        this.camera = camera;
    }
}
