package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 1000;
    private static int generateNumber = getRandomInt(BOUND, MIN_NUMBER);

    public static void startPlay() {
        int number = generateNumber;
        String[] round1 = roundsData(0, number);
        number = generateNumber;
        String[] round2 = roundsData(1, number);
        number = generateNumber;
        String[] round3 = roundsData(2, number);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int number) {
        String count = Integer.toString(count1);
        String questions = Integer.toString(number);
        boolean isSimple = isSimple(number);
        String result = isSimple ? "yes" : "no";
        return new String[]{result, questions, count};
    }

    public static boolean isSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
