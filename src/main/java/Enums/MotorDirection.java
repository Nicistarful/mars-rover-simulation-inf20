package Enums;

public enum MotorDirection {
    FORWARD("forward"),
    BACKWARD("backward");

    private final String motorDirection;

    MotorDirection(String d) {
        motorDirection = d;
    }
}
