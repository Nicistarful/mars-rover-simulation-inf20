package CameraEquipment;

import Rover.Camera;

import java.util.UUID;

public class Lens {
    private UUID uuid;
    private Camera camera;

    public Lens(Camera camera) {
        this.camera = camera;
    }
}
