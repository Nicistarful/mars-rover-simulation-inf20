package Rover;

import Helpers.Vector2D;
import Utility.ConsoleLogger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.Objects;

public class MarsRover {

    public MarsRover() {

    }

    private final String serialNumber = "X7UJ90MM";
    private final String name = "Curiosity";
    private final int mass = 899;
    private final LocalDate manufacturingDate = LocalDate.parse("20210607", DateTimeFormatter.BASIC_ISO_DATE);
    private boolean isStarted = false;
    private Vector2D currentPosition = new Vector2D(0,0);

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

    public long getRuntime(){
        return LocalDate.now().toEpochDay() - manufacturingDate.toEpochDay();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Vector2D getCurrentPosition() {
        return currentPosition;
    }

    public void moveUp(){
        currentPosition.add(new Vector2D(0,1));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveDown(){
        currentPosition.add(new Vector2D(0,-1));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveLeft(){
        currentPosition.add(new Vector2D(-1,0));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void moveRight(){
        currentPosition.add(new Vector2D(1,0));
        ConsoleLogger.log("Rover %s updated position to: %s".formatted(name, currentPosition));
    }

    public void start(){
        isStarted = true;
        ConsoleLogger.log("Rover %s is started: %s".formatted(name, isStarted));
    }

    public void shutdown(){
        isStarted = false;
        ConsoleLogger.log("Rover %s is started: %s".formatted(name, isStarted));
    }
}
