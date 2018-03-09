package ladder;

import ladder.util.LadderBuilder;
import ladder.util.LadderUtils;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();
    private String[] names;

    public Ladder(String[] names, int height) {
        this.names = names;
        setLadder(height, LadderUtils.calcLineNum(names.length));
    }

    private void setLadder(int height, int lineNum) {
        for (int h = 0; h < height; h++) {
            ladder.add(new Line(lineNum));
        }
    }

    public String buildLadder() {
        return LadderBuilder.build(ladder, names);
    }
}
