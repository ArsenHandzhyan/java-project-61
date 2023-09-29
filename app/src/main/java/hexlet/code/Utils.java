package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateNumber(int bound, int minNumber) {
        return new Random().nextInt(bound) + minNumber;
    }
}
