package Environment;

import Helpers.Vector2D;

import java.time.LocalDateTime;

public class ScientificSample {
    private long nanoTimestamp;
    private Vector2D location;

    public ScientificSample(Vector2D location, char[] content) {
        this.location = location;
        this.content = content;
        nanoTimestamp = LocalDateTime.now().getNano();
    }

    private char[] content;
}
