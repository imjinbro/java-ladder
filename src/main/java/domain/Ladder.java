package domain;

import java.util.ArrayList;

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

    private void setLadder(int pointNum, int height) {
        for (int h = 0; h < height; h++) {
            ladder.add(new Line(LineCreator.create(pointNum)));
        }
    }

    public Line getLine(int height) {
        return ladder.get(height);
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getStartHeight() {
        return ladder.size() - ladder.size();
    }

    public boolean isOverHeight(int heightIdx) {
        return ladder.size() <= heightIdx;
    }

    public ArrayList<Integer> getPlayerPositions() {
        Line firstLine = ladder.stream().findFirst().get();
        return firstLine.getPlayerPositions();
    }

    public int convertPositionToIdx(int position) {
        int spaceInterval = 2;
        return position / spaceInterval;
    }

    public int removeSpaceIdx(int idx) {
        int spaceInterval = 2;
        return idx / spaceInterval;
    }
}
