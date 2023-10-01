package hexlet.code.games;

import static hexlet.code.Engine.generateQuestionForProgression;
import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.getCount;

public class Progression {

    public static void startPlay() {
        System.out.println("What number is missing in the progression?");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        String[] results = generateQuestionForProgression();
        String progression = results[0];
        String result = results[1];
        askQuestion(progression);
        if (getCount(count, result) == 1) {
            newGamePlay(++count);
        }
    }
}
