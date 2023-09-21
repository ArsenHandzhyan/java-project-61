package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.randomGen;

public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void gameStart() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        newGame(0);
    }

    public static void newGame(int count) {
        int evenNum = randomGen(BOUND) + MIN_NUMBER;
        System.out.println("Question: " + evenNum);
        String result = evenNumber(evenNum);
        play(count, result);
    }

    public static void play(int count, String result) {
        String input = Engine.getString();
        Engine.getAnswer(input);
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulate();
                    System.exit(0);
                } else {
                    newGame(++count);
                }
            } else {
                Engine.getIncorrectAnswer(input, result);
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public static String evenNumber(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}

