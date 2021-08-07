package CameraEquipment;

import Helpers.Vector2D;

import java.sql.Timestamp;

public class Picture {
    private Timestamp nanoTimestamp;
    private Vector2D location;
    private String content;

    public void setNanoTimestamp(Timestamp nanoTimestamp) {
        this.nanoTimestamp = nanoTimestamp;
    }
}
