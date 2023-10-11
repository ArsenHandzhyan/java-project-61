package hexlet.code;

import static hexlet.code.Engine.run;

public class RoundsDataMaker {
    public static void roundsData(String[] round1, String[] round2, String[] round3, String description) {
        String[][] roundsData = {round1, round2, round3};
        run(description, roundsData, 0);
    }
}
