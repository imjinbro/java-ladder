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

    public boolean isMaxHeight(int heightIdx) {
        int maxHeightIdx = ladder.size() - 1;
        return maxHeightIdx == heightIdx;
    }

    public boolean canMovablePosition(int heightIdx, int position) {
        Line selectedLine = ladder.get(heightIdx);
        return selectedLine.isMovablePosition(position);
    }
}
