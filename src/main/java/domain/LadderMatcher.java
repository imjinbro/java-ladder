package domain;

import java.util.ArrayList;

public class LadderMatcher {
    // TODO : 리턴타입 조금 더 생각해보고 변경하기
    public static void match(Ladder ladder, Names names, Rewards rewards) {
        ArrayList<Result> results = getLadderRewardPair(ladder);

    }

    private static ArrayList<Result> getLadderRewardPair(Ladder ladder) {
        ArrayList<Result> results = new ArrayList<>();
        int pointNum = ladder.getPointNum();
        for (int playerNum = 0; playerNum < pointNum; playerNum += 2) {
            int startHeight = 0;
            results.add(new Result(playerNum, searchRewardPosition(ladder, startHeight, playerNum)));
        }
        return results;
    }

    private static int searchRewardPosition(Ladder ladder, int heightIdx, int position) {
        if (isFinishSearch(ladder, heightIdx)) {
            return position;
        }

        Line currentLine = ladder.getLine(heightIdx);
        position = movePosition(currentLine, position);
        return searchRewardPosition(ladder, moveHeight(heightIdx), position);
    }

    private static int movePosition(Line line, int position) {
        int movedPosition = moveLeftPosition(line, position);
        movedPosition = moveRightPosition(line, position, movedPosition);
        return movedPosition;
    }

    private static int moveLeftPosition(Line line, int position) {
        int currentPos = position;
        while (canMove(line, currentPos - 1)) {
            currentPos = currentPos - 1;
        }
        return currentPos;
    }

    private static int moveRightPosition(Line line, int startingPosition, int movedPosition) {
        if (isMovedHorizontal(startingPosition, movedPosition)) {
            return movedPosition;
        }

        int currentPos = movedPosition;
        while (canMove(line, currentPos + 1)) {
            currentPos = currentPos + 1;
        }
        return currentPos;
    }

    private static boolean isMovedHorizontal(int startingPosition, int movedPosition) {
        return startingPosition != movedPosition;
    }

    private static int moveHeight(int heightIdx) {
        return heightIdx + 1;
    }

    private static boolean canMove(Line line, int nextPosition) {
        try {
            return line.isDrawPosition(nextPosition);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean isFinishSearch(Ladder ladder, int currentHeightIdx) {
        return ladder.getHeight() <= currentHeightIdx;
    }
}
