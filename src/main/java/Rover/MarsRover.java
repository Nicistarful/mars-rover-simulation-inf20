package Rover;

import CameraEquipment.Picture;
import Enums.SortingOrder;
import Environment.MarsSurface;
import Environment.ScientificSample;
import Helpers.Vector2D;
import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.MovementManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MarsRover {

    private final String serialNumber = "X7UJ90MM";
    private final String name = "Curiosity";
    private final int mass = 899;
    private final LocalDate manufacturingDate = LocalDate.parse("20210607", DateTimeFormatter.BASIC_ISO_DATE);
    private final BatteryManagement batteryManagement;
    private final MovementManagement movementManagement;
    private final Vector2D currentPosition = new Vector2D(499, 499);
    private final Chassis chassis;
    private final ArrayList<Battery> batteries;
    private final ArrayList<SolarPanel> solarPanels;
    private final Camera camera;
    private final Gripper gripper;
    private boolean isStarted = false;
    private Queue<ScientificSample> scientificSampleQueue;

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
        solarPanels.forEach(SolarPanel::unfold);
        solarPanels.forEach(SolarPanel::collect);
        ConsoleLogger.log("Hi, I'm %s and am ready to explore!".formatted(name));
        scientificSampleQueue = new LinkedList<>();
    }

    public Chassis getChassis() {
        return chassis;
    }

    @Override
    public boolean equals(Object o) {
        MarsRover r = (MarsRover) o;
        return r.getSerialNumber() == this.getSerialNumber();
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

    public char getCurrentSurfacePosition() {
        return MarsSurface.getSurfaceStructure()[currentPosition.getyPos()][currentPosition.getxPos()];
    }

    public void extractSample() {
        char[] sample = gripper.extractSample(getCurrentPosition());
        scientificSampleQueue.add(new ScientificSample(getCurrentPosition(), sample));
    }

    public Camera getCamera() {
        return camera;
    }

    public void exportPicturesToCSV(SortingOrder sortingOrder){
        Camera c = getCamera();
        Stack<Picture> pictures = c.getMemoryCard().getPictures();
        File f = new File("src/main/resources/pictures.csv");
        try {
            FileWriter fw = new FileWriter(f);
            StringBuilder exportString = new StringBuilder();
            switch (sortingOrder) {
                case ASCENDING -> {
                    for (Picture picture : pictures) {
                        exportString.append("%s\n".formatted(picture.toString()));
                    }
                }
                case DESCENDING -> {
                    Stack<Picture> temp = new Stack<>();
                    while (!pictures.empty()){
                        temp.add(pictures.pop());
                    }
                    for (Picture picture : temp) {
                        exportString.append("%s\n".formatted(picture.toString()));
                    }
                }
            }
            fw.write(exportString.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }

    public MovementManagement getMovementManagement() {
        return movementManagement;
    }
}
