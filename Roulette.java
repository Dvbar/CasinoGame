import java.util.*;

public class Roulette {
    private int players = 0;
    private int[] money = new int[players];
    private int[] wheel = {0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26};
    private static final int WHEEL_SIZE = 37;
    private int access(int index) {
        int temp = index % WHEEL_SIZE;
        return wheel[temp];
    }

    public static void print() {
    }

    public static void bet() {
    }

    public static void spin() {
    }

    public static void play() {
    }
}
