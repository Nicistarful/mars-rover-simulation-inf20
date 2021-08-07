package CameraEquipment;

import Environment.MarsSurface;
import Helpers.Vector2D;

import java.util.Arrays;

public class Picture {
    private int nanoTimestamp;
    private Vector2D location;
    private char[] content;

    public Picture(int nanoTimestamp, Vector2D location, int width) {
        this.nanoTimestamp = nanoTimestamp;
        this.location = location;

        content = new char[width];
        char[] structure = MarsSurface.getSurfaceStructure()[location.getyPos() + 1];
        for (int i = 0; i < width; i++) {
            content[i] = structure[(location.getxPos() - Math.round((float)width/2f)) + i];
        }
    }

    @Override
    public String toString() {
        return "%d;%s;%s".formatted(nanoTimestamp, location, Arrays.toString(content));
    }
}
