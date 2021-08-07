package CameraEquipment;

import Rover.Camera;

import java.util.UUID;

public class Filter {
    private UUID uuid;
    private Camera camera;

    public Filter(Camera camera) {
        this.camera = camera;
    }
}
