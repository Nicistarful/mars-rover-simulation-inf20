package Environment;

import Utility.RandomMaker;

public final class MarsSurface {
    private static char[][] structure;

    public static void init() {
        structure = new char[1000][1000];
        char[] pool = new char[]{'w', 'a', 't', 'e', 'r', 'i', 'n'};
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                structure[i][j] = pool[RandomMaker.getRandomInt(0, pool.length - 1)];
            }
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
