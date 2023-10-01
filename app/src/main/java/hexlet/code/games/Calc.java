package hexlet.code.games;

import static hexlet.code.Engine.calculateExpression;
import static hexlet.code.Engine.generateSign;
import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.getCount;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 51;


    public static void startPlay() {
        System.out.println("What is the result of the expression?");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int num1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        int num2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = String.valueOf(calculateExpression(num1, num2, sign));
        askQuestion(expression);
        if (getCount(count, result) == 1) {
            newGamePlay(++count);
        }
    }


}
