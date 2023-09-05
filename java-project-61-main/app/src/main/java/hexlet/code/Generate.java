package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public interface Generate {
    static String nameS() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    static int randomGen() {
        Random rand = new Random();
        return rand.nextInt(50);
    }
}

