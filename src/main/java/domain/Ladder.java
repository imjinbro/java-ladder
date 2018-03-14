package domain;

import view.LadderViewBuilder;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum, int height) {
        setLadder(height, LadderUtils.calcPointNumOfLine(playerNum));
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

    public String buildViewMode(Names names, int maxNameLength) {
        return LadderViewBuilder.build(this, names, maxNameLength);
    }
}
