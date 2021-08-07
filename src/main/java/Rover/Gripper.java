package Rover;

import Environment.MarsSurface;
import Helpers.Vector2D;

public class Gripper {
    public char[] extractSample(Vector2D position){
        char[] sample = new char[7];
        char[] structure = MarsSurface.getSurfaceStructure()[position.getyPos()];
        for (int i = 0; i < sample.length - 1; i++) {
            sample[i] = structure[position.getxPos() - 3 + i];
        }
        return sample;
    }
}
