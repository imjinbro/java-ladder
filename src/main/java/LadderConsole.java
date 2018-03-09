import io.Input;
import io.Viewer;
import ladder.Ladder;

public class LadderConsole {
    public static void main(String[] args) {
        LadderConsole.start();
    }

    public static void start() {
        Ladder ladder = new Ladder(getPlayersName(), getMaxHeight());
        Viewer.viewLadder(ladder);
    }

    private static String[] getPlayersName() {
        Viewer.viewMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] names = dividePlayersName(Input.getPlayerNames());
        while (isInvalidNames(names)) {
            Viewer.viewMessage("플레이어 이름을 잘못 입력하였습니다(2명 이상 입력, 1명 당 이름 5자 이하)\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            names = dividePlayersName(Input.getPlayerNames());
        }

        return names;
    }

    private static boolean isInvalidNames(String[] names) {
        return names == null || isInvalidPlayerNum(names.length) || isIncludeInvalidName(names);
    }

    private static boolean isInvalidPlayerNum(int playerNum) {
        int minPlayerNum = 2;
        return playerNum < minPlayerNum;
    }

    private static boolean isIncludeInvalidName(String[] names) {
        int playerNum = names.length;
        int checkCount = 0;

        while (!isFinishCheck(playerNum, checkCount) && isValidNameLength(names[checkCount])) {
            checkCount++;
        }

        return !isFinishCheck(playerNum, checkCount);
    }

    private static boolean isFinishCheck(int playerNum, int checkCount) {
        return playerNum == checkCount;
    }

    private static boolean isValidNameLength(String name) {
        int maxLength = 5;
        return name.length() <= maxLength;
    }

    private static int getMaxHeight() {
        int maxHeight = -1;
        while (isInvalidHeight(maxHeight)) {
            Viewer.viewMessage("최대 사다리 높이는 몇 개인가요 (1이상, 잘못된 입력 시 재입력)");
            maxHeight = Input.getNumber();
        }

        return maxHeight;
    }

    private static boolean isInvalidHeight(int height) {
        return height < 1;
    }

    private static String[] dividePlayersName(String playersName) {
        String removedPlayersName = removeEmptySpace(playersName);
        String delimiter = ",";
        return removedPlayersName.split(delimiter);
    }

    private static String removeEmptySpace(String playersName) {
        return playersName.replace(" ", "");
    }
}
