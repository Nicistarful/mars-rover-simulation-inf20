package Builders;

import Rover.*;
import Utility.BatteryManagement;
import Utility.MovementManagement;

import java.util.ArrayList;

public class MarsRoverBuilder {
    private BatteryManagement batteryManagement;
    private MovementManagement movementManagement;
    private Chassis chassis;
    private ArrayList<Battery> batteries;
    private ArrayList<SolarPanel> solarPanels;
    private Camera camera;

    public MarsRoverBuilder setBatteryManagement(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        return this;
    }

    public MarsRoverBuilder setMovementManagement(MovementManagement movementManagement) {
        this.movementManagement = movementManagement;
        return this;
    }

    public MarsRoverBuilder setChassis(Chassis chassis) {
        this.chassis = chassis;
        return this;
    }

    public MarsRoverBuilder setBatteries(ArrayList<Battery> batteries) {
        this.batteries = batteries;
        return this;
    }

    public MarsRoverBuilder setSolarPanels(ArrayList<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
        return this;
    }

    public MarsRoverBuilder setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    public MarsRover createMarsRover() {
        return new MarsRover(batteryManagement, movementManagement, chassis, batteries, solarPanels, camera);
    }
}