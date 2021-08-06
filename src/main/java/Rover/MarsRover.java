package Rover;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.Objects;

public class MarsRover {
    private final String serialNumber = "X7UJ90MM";
    private final String name = "Curiosity";
    private final int mass = 899;
    private final LocalDate manufacturingDate = LocalDate.parse("20210607", DateTimeFormatter.BASIC_ISO_DATE);
    private final boolean isStarted = false;

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
}
