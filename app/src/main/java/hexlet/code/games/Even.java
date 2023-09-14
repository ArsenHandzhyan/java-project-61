package hexlet.code.games;


import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Even {

    public static void gameStart() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        newGame(0);
    }

    public static void newGame(int count) {
        int startNumber = 1;
        int evenNum = randomGen(101) + startNumber;
        System.out.println("Question: " + evenNum);
        String game = "2";
        game(count, evenNumber(evenNum), game);
    }

    public static String evenNumber(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}

