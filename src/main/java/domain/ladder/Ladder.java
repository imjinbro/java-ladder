package domain.ladder;

import domain.ladder.util.LadderBuilder;
import domain.ladder.util.LadderUtils;
import domain.ladder.util.LineBuilder;

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
            ladder.add(new Line(LineBuilder.build(pointNum)));
        }
    }

    public String buildLadder(int maxNameLength) {
        return LadderBuilder.build(ladder, names, maxNameLength);
    }
}
