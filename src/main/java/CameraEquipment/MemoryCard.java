package CameraEquipment;

import java.util.Stack;

public class MemoryCard {
    private Stack<Picture> pictures;

    public MemoryCard() {
        pictures = new Stack<>();
    }

    public Stack<Picture> getPictures() {
        return pictures;
    }
}
