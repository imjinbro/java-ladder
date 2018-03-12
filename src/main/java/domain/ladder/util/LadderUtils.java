package domain.ladder.util;

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

    public static int calcPointNumOfLine(int playerNum) {
        int allPointNum = playerNum * 2;
        int extraSpaceNum = 1;
        return allPointNum- extraSpaceNum;
    }
}
