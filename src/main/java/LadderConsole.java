import io.Input;
import io.Viewer;
import ladder.Ladder;

public class LadderConsole {
    public static void main(String[] args) {
        LadderConsole.start();
    }

    public static void start() {
        Ladder ladder = new Ladder(getPlayerNum(), getMaxHeight());
        Viewer.viewLadder(ladder);
    }

    private static int getPlayerNum() {
        Viewer.viewMessage("참여할 사람은 몇 명 인가요 (1명 이상, 잘못된 입력 시 종료)");
        int playerNum = Input.getInt();
        if (isInvalidTypeNum(playerNum)) {
            Viewer.viewMessage("잘못된 입력으로 프로그램을 종료합니다");
            System.exit(-1);
        }

        return playerNum;
    }

    private static int getMaxHeight() {
        int maxHeight = -1;
        while (isInvalidTypeNum(maxHeight)) {
            Viewer.viewMessage("최대 사다리 높이는 몇 개인가요 (1이상, 잘못된 입력 시 재입력)");
            maxHeight = Input.getInt();
        }

        return maxHeight;
    }

    private static boolean isInvalidTypeNum(int typeNum) {
        return typeNum < 1;
    }
}
