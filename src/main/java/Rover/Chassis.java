package Rover;

import java.util.ArrayList;

public class Chassis {
    private ArrayList<Suspension> suspensions = new ArrayList<>();

    public Chassis() {
        for (int i = 0; i < 6; i++) {
            suspensions.add(new Suspension());
        }
    }

    public ArrayList<Suspension> getSuspensions() {
        return suspensions;
    }
}
