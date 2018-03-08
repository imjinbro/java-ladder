package ladder.util;

import java.util.Random;

public class LadderUtils {

    public static boolean isEvenNumPos(int pos) {
        return pos % 2 == 0;
    }

    public static boolean choiceDraw() {
        boolean[] resCandidate = {true, false};
        return resCandidate[new Random().nextInt(resCandidate.length)];
    }

}
