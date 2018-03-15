package domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum, int height) {
        setLadder(LadderUtils.calcPointNumOfLine(playerNum), height);
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

    public int getPointNum() {
        Line lastLine = ladder.get(ladder.size() - 1);
        return lastLine.getPointNum();
    }
}
