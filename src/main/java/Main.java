import domain.*;
import view.Input;
import view.Viewer;

public class Main {
    private static final String EXIT_KEY = "-1";

    public static void main(String[] args) {
        Main.start();
    }

    public static void start() {
        Names playersName = getPlayersName();
        Rewards rewards = getReward(playersName.getPlayerNumber());
        Ladder ladder = setLadder(playersName.getPlayerNumber());
        showLadder(ladder, playersName, rewards);

        Results allResult = LadderMatcher.match(ladder, playersName, rewards);
        showResult(allResult, playersName);
    }

    private static void showLadder(Ladder ladder, Names playerNames, Rewards rewards) {
        Viewer.viewLadder(ladder, playerNames, rewards);
    }

    private static void showResult(Results allResult, Names playersName) {
        String searchName = getResultName(playersName);
        while (!isFinishKey(searchName)) {
            Name wrapName = new Name(searchName);
            Viewer.viewResult(allResult, wrapName);
            searchName = getResultName(playersName);
        }
        Viewer.viewMessage("게임 종료");
    }

    private static boolean isFinishKey(String userInput) {
        return EXIT_KEY.equals(userInput);
    }

    private static Names getPlayersName() {
        String[] names = Input.getPlayerNames("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Names playerNames = null;
        try {
            playerNames = new Names(names);
        } catch (IllegalArgumentException e) {
            Viewer.viewMessage(e.getMessage());
            playerNames = getPlayersName();
        }
        return playerNames;
    }

    private static Rewards getReward(int playerNum) {
        String[] rewards = Input.getRewards("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분)");
        Rewards playerRewards = null;
        try {
            playerRewards = new Rewards(rewards, playerNum);
        } catch (IllegalArgumentException e) {
            Viewer.viewMessage(e.getMessage());
            playerRewards = getReward(playerNum);
        }
        return playerRewards;
    }

    private static Ladder setLadder(int playerNum) {
        Ladder ladder = null;
        int height = getHeight();
        try {
            ladder = new Ladder(playerNum, height);
        } catch (IllegalArgumentException e) {
            Viewer.viewMessage(e.getMessage());
            ladder = setLadder(playerNum);
        }
        return ladder;
    }

    private static int getHeight() {
        int height = -1;
        try {
            height = Input.getHeight("최대 사다리 높이는 몇 개인가요");
        } catch (NumberFormatException e) {
            Viewer.viewMessage(e.getMessage());
            height = getHeight();
        }
        return height;
    }

    private static String getResultName(Names names) {
        Viewer.viewMessage("결과를 보고 싶은 사람은? (종료 방법 : " + EXIT_KEY + " 입력)");
        return Input.getResultName(names, EXIT_KEY);
    }
}
