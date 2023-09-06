package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public interface Generate {
    static String string() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static int randomGen(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
}

