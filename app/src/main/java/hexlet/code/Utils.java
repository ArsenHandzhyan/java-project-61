package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int minNumber, int bound) {
        return new Random().nextInt(minNumber, bound);
    }
}
