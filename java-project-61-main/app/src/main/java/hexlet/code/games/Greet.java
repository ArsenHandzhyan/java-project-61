package hexlet.code.games;

import static hexlet.code.Engine.greet;

public class Greet {
    public static void gameStart() {
        for (int count = 0; count <= 2; count++) {
            greet();
        }
    }
}
