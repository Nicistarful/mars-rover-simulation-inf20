package Rover;

import Environment.MarsSurface;
import Environment.ScientificSample;
import Helpers.Vector2D;
import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.MovementManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Queue;

public class MarsRover {

    private final String serialNumber = "X7UJ90MM";
    private final String name = "Curiosity";
    private final int mass = 899;
    private final LocalDate manufacturingDate = LocalDate.parse("20210607", DateTimeFormatter.BASIC_ISO_DATE);
    private BatteryManagement batteryManagement;
    private MovementManagement movementManagement;
    private Vector2D currentPosition = new Vector2D(499, 499);
    private boolean isStarted = false;
    private Chassis chassis;
    private ArrayList<Battery> batteries;
    private ArrayList<SolarPanel> solarPanels;
    private Camera camera;
    private Queue<ScientificSample> scientificSampleQueue;
    private Gripper gripper;

    public MarsRover(BatteryManagement batteryManagement,
                     MovementManagement movementManagement,
                     Chassis chassis,
                     ArrayList<Battery> batteries,
                     ArrayList<SolarPanel> solarPanels,
                     Camera camera, Gripper gripper) {
        this.batteryManagement = batteryManagement;
        this.movementManagement = movementManagement;
        this.chassis = chassis;
        this.batteries = batteries;
        this.solarPanels = solarPanels;
        this.camera = camera;
        this.gripper = gripper;
    }

    public Chassis getChassis() {
        return chassis;
    }

    @Override
    public boolean equals(Object o) {
        MarsRover rover = null;
        try {
            rover = (MarsRover) o;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return rover.getSerialNumber() == this.serialNumber;
    }

    @Override
    public String toString() {
        return "[MarsRover] name = %s | mass (net) = %d | mass (scientific) = %d | runtime = %d days".formatted(name,
                mass - 90,
                mass,
                getRuntime());
    }

    public long getRuntime() {
        return LocalDate.now().toEpochDay() - manufacturingDate.toEpochDay();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Vector2D getCurrentPosition() {
        return currentPosition;
    }

    public void moveUp() {
        movementManagement.moveUp();
        currentPosition.add(new Vector2D(0, 1));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveDown() {
        movementManagement.moveDown();
        currentPosition.add(new Vector2D(0, -1));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveLeft() {
        movementManagement.turnLeft();
        currentPosition.add(new Vector2D(-1, 0));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveRight() {
        movementManagement.turnRight();
        currentPosition.add(new Vector2D(1, 0));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void start() {
        isStarted = true;
        ConsoleLogger.log("Rover %s is started: %s".formatted(name, isStarted));
    }

    public void shutdown() {
        isStarted = false;
        ConsoleLogger.log("Rover %s is started: %s".formatted(name, isStarted));
    }

    public char getCurrentSurfacePosition(){
        return MarsSurface.getSurfaceStructure()[currentPosition.getyPos()][currentPosition.getxPos()];
    }

    public void extractSample(){
        char[] sample = gripper.extractSample(currentPosition);
        scientificSampleQueue.add(new ScientificSample(currentPosition, sample));
    }
}
