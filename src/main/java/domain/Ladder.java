package domain;

import java.util.ArrayList;

import static domain.LineCreator.createLine;

public class Ladder {
    private static final int MIN_HEIGHT = 2;
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum, int height) throws IllegalArgumentException {
        if (isInvalidHeight(height)) {
            throw new IllegalArgumentException(MIN_HEIGHT + "이상 높이 설정해야합니다.");
        }
        setLadder(LadderUtils.calcPointNumOfLine(playerNum), height);
    }

    static boolean isInvalidHeight(int height) {
        return MIN_HEIGHT > height;
    }

    private void setLadder(int pointNum, int heightLimit) {
        for (int heightIdx = 0; heightIdx < heightLimit; heightIdx++) {
            Line line = new Line(createLine(pointNum));
            ladder.add(line);
        }
    }

    public boolean isMovablePosition(int heightIdx, int position) {
        if (isMaxHeight(heightIdx)) {
            return false;
        }
        Line selectedLine = ladder.get(heightIdx);
        return selectedLine.isMovablePosition(position);
    }

    public boolean isPlayerPosition(int position) {
        Line firstLine = getFirstLine();
        return firstLine.isPlayerPosition(position);
    }

    public boolean isMaxHeight(int heightIdx) {
        int maxHeightIdx = ladder.size() - 1;
        return maxHeightIdx == heightIdx;
    }

    public boolean isLimitPointNum(int pointIdx) {
        Line firstLine = getFirstLine();
        return firstLine.isLimitPointNum(pointIdx);
    }

    private Line getFirstLine() {
        Line firstLine = ladder.get(0);
        return firstLine;
    }

    public boolean canLeftMove(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.canLeftMove(position);
    }

    public boolean canRightMove(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.canRightMove(position);
    }

    public int moveLeft(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.moveLeft(position);
    }

    public int moveDown(int heightIdx) {
        return heightIdx + 1;
    }

    public int moveRight(int heightIdx, int position) {
        Line line = ladder.get(heightIdx);
        return line.moveRight(position);
    }

    public int getPlayerNumUsingIdx(int playerIdx) {
        int positionNum = playerIdx / 2;
        return positionNum;
    }
}
