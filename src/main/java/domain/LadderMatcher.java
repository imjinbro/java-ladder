package domain;

public class LadderMatcher {

    public static Results match(Ladder ladder, Names names, Rewards rewards) {
        Results results = new Results();
        int pointIdx = 0;
        while (!ladder.isLimitPointNum(pointIdx)) {
            if (ladder.isPlayerPosition(pointIdx)) {
                int playerPosition = ladder.getPlayerNumUsingIdx(pointIdx);
                int rewardIdx = searchRewardIdx(ladder, pointIdx);
                results.addResult(names.getPlayerName(playerPosition), rewards.getReward(rewardIdx));
            }
            pointIdx++;
        }
        return results;
    }

    private static int searchRewardIdx(Ladder ladder, int startPosition) {
        int startHeightIdx = 0;
        int rewardIdx = doSearch(ladder, startHeightIdx, startPosition);
        return ladder.getPlayerNumUsingIdx(rewardIdx);
    }

    private static int doSearch(Ladder ladder, int heightIdx, int pointIdx) {
        if (!ladder.isMovablePosition(heightIdx, pointIdx)) {
            return pointIdx;
        }
        pointIdx = movePosition(ladder, heightIdx, pointIdx);
        return doSearch(ladder, ladder.moveDown(heightIdx), pointIdx);
    }

    private static int movePosition(Ladder ladder, int heightIdx, int pointIdx) {
        int currentPointIdx = moveLeftPosition(ladder, heightIdx, pointIdx);
        currentPointIdx = moveRightPosition(ladder, heightIdx, pointIdx, currentPointIdx);
        return currentPointIdx;
    }

    private static int moveLeftPosition(Ladder ladder, int heightIdx, int pointIdx) {
        int currentPointIdx = pointIdx;
        while (ladder.canLeftMove(heightIdx, currentPointIdx)) {
            currentPointIdx = ladder.moveLeft(heightIdx, currentPointIdx);
        }
        return currentPointIdx;
    }

    private static int moveRightPosition(Ladder ladder, int heightIdx, int startPointIdx, int currentPointIdx) {
        if (startPointIdx != currentPointIdx) {
            return currentPointIdx;
        }

        while (ladder.canRightMove(heightIdx, currentPointIdx)) {
            currentPointIdx = ladder.moveRight(heightIdx, currentPointIdx);
        }
        return currentPointIdx;
    }
}