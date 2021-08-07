package Environment;

import java.util.Arrays;
import java.util.Random;

public final class MarsSurface {
    private static final char[][] structure = new char[1000][1000];

    public MarsSurface() {
        char[] pool = new char[]{'w', 'a', 't', 'e', 'r', 'i', 'n'};
        for (char[] subArray : structure) {
            Arrays.fill(subArray, pool[new Random(new Random().nextInt(9154)).nextInt(pool.length)]);
        }
    }

    public static void visualize() {
        for (char[] subArray : structure) {
            for (char c : subArray) {
                System.out.printf("%s ", c);
            }
            System.out.println();
        }
    }

    public static char[][] getSurfaceStructure(){
        return structure;
    }
}
