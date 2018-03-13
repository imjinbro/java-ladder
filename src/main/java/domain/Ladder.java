package domain;

import view.LadderViewBuilder;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();
    private Names names;

    public Ladder(String[] names, int height) {
        this.names = new Names(names);
        setLadder(height, LadderUtils.calcPointNumOfLine(names.length));
    }

    private void setLadder(int height, int pointNum) {
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

    public String buildViewMode(int maxNameLength) {
        return LadderViewBuilder.build(this, names, maxNameLength);
    }
}
