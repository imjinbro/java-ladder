package view;

import domain.Names;
import domain.Rewards;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getHeight(int minHeight) {
        try {
            int height = Integer.parseInt(scanner.nextLine());
            return verifyHeight(minHeight, height);
        } catch (NumberFormatException e) {
            Viewer.viewMessage("숫자를 입력해주세요.");
            return getHeight(minHeight);
        } catch (UpperStandardException e) {
            Viewer.viewMessage(minHeight + "이하 입력해야합니다.");
            return getHeight(minHeight);
        }
    }

    static int verifyHeight(int minHeight, int height) throws UpperStandardException {
        if (minHeight > height) {
            throw new UpperStandardException("");
        }
        return height;
    }

    static class UpperStandardException extends Exception {
        UpperStandardException(String msg) {
            super(msg);
        }
    }

    public static Names getPlayerNames(int minPlayerNum, int maxNameLength) {
        String[] names = divideUserInput(scanner.nextLine());
        while (isInvalidPlayerNum(minPlayerNum, names.length)) {
            printError(minPlayerNum + "명 이상 입력해야합니다.");
            return getPlayerNames(minPlayerNum, maxNameLength);
        }

        while (isIncludeOverLengthName(maxNameLength, names)) {
            printError(maxNameLength + "자 이상이어야 합니다");
            return getPlayerNames(minPlayerNum, maxNameLength);
        }
        return new Names(names);
    }

    private static void printError(String errorMessage) {
        Viewer.viewMessage(errorMessage);
    }

    static boolean isInvalidPlayerNum(int minPlayerNum, int playerNum) {
        return minPlayerNum > playerNum;
    }

    private static boolean isIncludeOverLengthName(int maxNameLength, String[] names) {
        int playerNum = names.length;
        int checkCount = 0;

        while (!isFinishCheck(playerNum, checkCount) && isValidNameLength(maxNameLength, names[checkCount])) {
            checkCount++;
        }
        return !isFinishCheck(playerNum, checkCount);
    }

    private static boolean isFinishCheck(int playerNum, int checkCount) {
        return playerNum == checkCount;
    }

    static boolean isValidNameLength(int maxNameLength, String name) {
        return name.length() <= maxNameLength;
    }

    static String[] divideUserInput(String playersName) {
        String removedPlayersName = removeEmptySpace(playersName);
        String delimiter = ",";
        return removedPlayersName.split(delimiter);
    }

    static String removeEmptySpace(String playersName) {
        return playersName.replace(" ", "");
    }

    public static Rewards getRewards(int playerNum) {
        String[] rewards = divideUserInput(scanner.nextLine());
        while(isInvalidRewardNum(playerNum, rewards.length)) {
            printError(playerNum + "개를 입력해야합니다");
            return getRewards(playerNum);
        }
        return new Rewards(rewards);
    }

    private static boolean isInvalidRewardNum(int playerNum, int rewardNum) {
        return playerNum != rewardNum;
    }

}
