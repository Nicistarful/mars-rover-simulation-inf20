package Builders;

import Rover.*;
import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.MovementManagement;

import java.util.ArrayList;

public class MarsRoverBuilder {
    private BatteryManagement batteryManagement;
    private MovementManagement movementManagement;
    private Chassis chassis;
    private ArrayList<Battery> batteries;
    private ArrayList<SolarPanel> solarPanels;
    private Camera camera;
    private Gripper gripper;

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }

    public MarsRoverBuilder setBatteryManagement(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        return this;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public MarsRoverBuilder setChassis(Chassis chassis) {
        this.chassis = chassis;
        return this;
    }

    public MarsRoverBuilder setMovementManagement(MovementManagement movementManagement) {
        this.movementManagement = movementManagement;
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

    public MarsRoverBuilder setGripper(Gripper gripper) {
        this.gripper = gripper;
        return this;
    }

    public MarsRover createMarsRover() {
        ConsoleLogger.log("New Rover created!");
        return new MarsRover(batteryManagement, movementManagement, chassis, batteries, solarPanels, camera, gripper);
    }
}