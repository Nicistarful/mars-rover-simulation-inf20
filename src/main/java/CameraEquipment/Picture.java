package CameraEquipment;

import Helpers.Vector2D;
import Utility.RandomMaker;

public class Picture {
    private int nanoTimestamp;
    private Vector2D location;
    private String content;

    public Picture(int nanoTimestamp, Vector2D location) {
        this.nanoTimestamp = nanoTimestamp;
        this.location = location;

        String charPool = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        int randomIndex = RandomMaker.getRandomInt(0, charPool.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(charPool.substring(randomIndex));
            if(i % 100 == 0){
                System.out.println();
            }
        }
        content = sb.toString();
    }
}
