import domain.Ladder;
import view.Input;
import view.Viewer;

public class Main {
    private static final int MIN_PLAYER_NUM = 2;
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Main.start();
    }

    public static void start() {
        Ladder ladder = new Ladder(getPlayersName(), getMaxHeight());
        Viewer.viewLadder(ladder, MAX_NAME_LENGTH);
    }

    private static String[] getPlayersName() {
        String printMessage = "참여할 사람 이름을 입력하세요. (" + MIN_PLAYER_NUM + "명 이상 이름 입력, 이름은 쉼표(,)로 구분, 최대 " + MAX_NAME_LENGTH + "자까지 입력가능)";
        Viewer.viewMessage(printMessage);

        String[] names = dividePlayersName(Input.getPlayerNames());
        while (isInvalidNames(names)) {
            Viewer.viewMessage("플레이어 이름을 잘못 입력하였습니다\n" + printMessage);
            names = dividePlayersName(Input.getPlayerNames());
        }
        return names;
    }

    private static boolean isInvalidNames(String[] names) {
        return names == null || isInvalidPlayerNum(names.length) || isIncludeInvalidName(names);
    }

    static boolean isInvalidPlayerNum(int playerNum) {
        return playerNum < MIN_PLAYER_NUM;
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

    static boolean isValidNameLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    private static int getMaxHeight() {
        int maxHeight = -1;
        while (isInvalidHeight(maxHeight)) {
            Viewer.viewMessage("최대 사다리 높이는 몇 개인가요 (" + MIN_HEIGHT + "이상, 잘못된 입력 시 재입력)");
            maxHeight = Input.getNumber();
        }
        return maxHeight;
    }

    static boolean isInvalidHeight(int height) {
        return height < MIN_HEIGHT;
    }

    static String[] dividePlayersName(String playersName) {
        String removedPlayersName = removeEmptySpace(playersName);
        String delimiter = ",";
        return removedPlayersName.split(delimiter);
    }

    static String removeEmptySpace(String playersName) {
        return playersName.replace(" ", "");
    }
}
