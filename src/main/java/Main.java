import domain.Ladder;
import domain.Names;
import domain.Rewards;
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
        Names playersName = getPlayersName();
        int playerNum = playersName.getPlayerNumber();
        Rewards rewards = getReward(playerNum);

        Ladder ladder = new Ladder(playerNum, getMaxHeight());
        Viewer.viewLadder(ladder, playersName, rewards, MAX_NAME_LENGTH);
    }

    private static Names getPlayersName() {
        Viewer.viewMessage("참여할 사람 이름을 입력하세요. (" + MIN_PLAYER_NUM + "명 이상 이름 입력, 이름은 쉼표(,)로 구분, 최대 " + MAX_NAME_LENGTH + "자까지 입력가능)");
        return Input.getPlayerNames(MIN_PLAYER_NUM, MAX_NAME_LENGTH);
    }

    private static Rewards getReward(int playerNum) {
        Viewer.viewMessage("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분, " + playerNum + "개 입력해야함)");
        return Input.getRewards(playerNum);
    }

    private static int getMaxHeight() {
        Viewer.viewMessage("최대 사다리 높이는 몇 개인가요 (" + MIN_HEIGHT + "이상 입력해주세요)");
        return Input.getHeight(MIN_HEIGHT);
    }
}
