package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getRandomInt(int bound, int minNumber) {
        return new Random().nextInt(minNumber, bound);
    }

    public static String getString() {
        return SCANNER.nextLine();
    }
}
