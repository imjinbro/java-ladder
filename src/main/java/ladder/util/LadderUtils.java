package ladder.util;

import java.util.Random;

public class LadderUtils {

    public static boolean isEvenNumPos(int pos) {
        return pos % 2 == 0;
    }

    public static boolean selectDrawOrNotDraw() {
        boolean[] resCandidate = {true, false};
        return resCandidate[getRandomIndex(resCandidate.length)];
    }

    private static int getRandomIndex(int bound) {
        return new Random().nextInt(bound);
    }

    public static String[] devidePlayersName(String playersName) {
        String delimiter = ",";
        return playersName.split(delimiter);
    }
}
