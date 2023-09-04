package hexlet.code;

import java.util.Scanner;

public interface Generate {
    static String nameS() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

