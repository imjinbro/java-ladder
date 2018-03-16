package domain;

import java.util.ArrayList;

public class LadderMatcher {

    public static Results match(Ladder ladder, Names names, Rewards rewards) {
        Results results = new Results();
        ArrayList<Integer> playerPositions = ladder.getPlayerPositions();
        for (Integer position : playerPositions) {
            int startHeight = ladder.getStartHeight();
            int rewardPosition = searchRewardPosition(ladder, startHeight, position);
            int playerIdx = ladder.convertPositionToIdx(position);
            saveResult(results, names.getPlayerName(playerIdx), rewards.getReward(rewardPosition));
        }
        return results;
    }

    private static void saveResult(Results results, String name, String reward) {
        results.addResult(name, reward);
    }

    private static int searchRewardPosition(Ladder ladder, int heightIdx, int position) {
        if (ladder.isOverHeight(heightIdx)) {
            return ladder.removeSpaceIdx(position);
        }
        Line currentLine = ladder.getLine(heightIdx);
        position = movePosition(currentLine, position);
        return searchRewardPosition(ladder, moveHeight(heightIdx), position);
    }

    private static int movePosition(Line line, int position) {
        int currentPosition = moveLeftPosition(line, position);
        return moveRightPosition(line, position, currentPosition);
    }

    static int moveLeftPosition(Line line, int position) {
        int currentPosition = position;
        while (line.canMove(currentPosition - 1)) {
            currentPosition = currentPosition - 1;
        }
        return currentPosition;
    }

    static int moveRightPosition(Line line, int startPosition, int currentPosition) {
        if (currentPosition != startPosition) {
            return currentPosition;
        }

        while (line.canMove(currentPosition + 1)) {
            currentPosition = currentPosition + 1;
        }
        return currentPosition;
    }

    private static int moveHeight(int heightIdx) {
        return heightIdx + 1;
    }
}