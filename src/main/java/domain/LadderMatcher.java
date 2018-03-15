package domain;

public class LadderMatcher {

    public static Results match(Ladder ladder, Names names, Rewards rewards) {
        Results results = new Results();
        for (int i = 0; i < names.getPlayerNumber(); i++) {
            int startHeight = 0;
            int startPosition = syncSkipPlayerIdx(i);
            int rewardPosition = searchRewardPosition(ladder, startHeight, startPosition);
            results.addResult(names.getPlayerName(i), rewards.getReward(rewardPosition));
        }
        return results;
    }

    private static int syncSkipPlayerIdx(int playerIdx) {
        if (playerIdx == 0) {
            return playerIdx;
        }
        int spaceIdx = 2;
        return playerIdx * spaceIdx;
    }

    private static int syncSkipRewardIdx(int rewardIdx) {
        int spaceIdx = 2;
        return rewardIdx / spaceIdx;
    }

    private static int searchRewardPosition(Ladder ladder, int heightIdx, int position) {
        if (isFinishSearch(ladder, heightIdx)) {
            return syncSkipRewardIdx(position);
        }
        Line currentLine = ladder.getLine(heightIdx);
        position = movePosition(currentLine, position);
        return searchRewardPosition(ladder, moveHeight(heightIdx), position);
    }

    private static int movePosition(Line line, int position) {
        int currentPosition = moveLeftPosition(line, position);
        return moveRightPosition(line, position, currentPosition);
    }

    private static int moveLeftPosition(Line line, int position) {
        int currentPosition = position;
        while (canMove(line, currentPosition - 1)) {
            currentPosition = currentPosition - 1;
        }
        return currentPosition;
    }

    private static int moveRightPosition(Line line, int startPosition, int currentPosition) {
        if (currentPosition != startPosition) {
            return currentPosition;
        }

        while (canMove(line, currentPosition + 1)) {
            currentPosition = currentPosition + 1;
        }
        return currentPosition;
    }

    private static boolean canMove(Line line, int nextPosition) {
        try {
            return line.isDrawPosition(nextPosition);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private static int moveHeight(int heightIdx) {
        return heightIdx + 1;
    }

    private static boolean isFinishSearch(Ladder ladder, int currentHeightIdx) {
        return ladder.getHeight() <= currentHeightIdx;
    }
}