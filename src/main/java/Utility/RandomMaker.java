package Utility;

public final class RandomMaker {
    public static int[] getRandomIntArray(int min, int max, int amount){
        int[] randomAmount = new int[amount];
        for (int i : randomAmount) {
            i = (int)Math.round((Math.random() * (max - min)) + min);
        }
        return randomAmount;
    }

    public static int getRandomInt(int min, int max){
        return (int)Math.round((Math.random() * (max - min)) + min);
    }
}
