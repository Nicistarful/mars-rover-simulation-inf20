package Rover;

import Utility.ConsoleLogger;

import java.rmi.server.UID;

public class BatteryCell {
    private UID uid = new UID();
    private final int[][][] energy = new int[100][10][10];
    private float percentageFull = 0f;

    public void charge(int amount) {
        if (percentageFull < 1f) {
            for (int i = 0; i < energy.length; i++) {
                for (int j = 0; j < energy[i].length; j++) {
                    for (int k = 0; k < energy[i][j].length; k++) {
                        if (energy[i][j][k] == 0) {
                            if (amount != 0) {
                                energy[i][j][k] = 1;
                                amount--;
                            }
                        }
                    }
                }
            }
        }
        updatePercentageFull();
    }

    public void discharge(int amount) {
        if (percentageFull > 0f) {
            for (int i = energy.length - 1; i != -1; i--) {
                for (int j = energy[i].length - 1; j != -1; j--) {
                    for (int k = energy[i][j].length - 1; k != -1; k--) {
                        if (energy[i][j][k] == 1) {
                            if (amount != 0) {
                                energy[i][j][k] = 0;
                                amount--;
                            }
                        }
                    }
                }
            }
        }
        updatePercentageFull();
    }

    public void visualize() {
        for (int[][] level1 : energy) {
            for (int[] level2 : level1) {
                for (int element : level2) {
                    System.out.printf("%d ", element);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private void updatePercentageFull(){
        float chargeCount = 0f;
        for (int[][] level1 : energy) {
            for (int[] level2 : level1) {
                for (int element : level2) {
                    if (element == 1) chargeCount++;
                }
            }
        }
        percentageFull = (chargeCount / 10000f);
        if (percentageFull == 0f) {
            ConsoleLogger.log("Battery cell is empty! (UID: %s)".formatted(getUuid()));
        }
        if (percentageFull == 1f) {
            ConsoleLogger.log("Battery cell is full! (UID: %s)".formatted(getUuid()));
        }
    }

    public float getPercentageFull() {
        return percentageFull*100f;
    }

    public UID getUuid() {
        return uid;
    }
}
