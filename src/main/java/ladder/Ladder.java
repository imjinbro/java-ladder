package ladder;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum, int height) {
        setLadder(height, calcLineNum(playerNum));
    }

    private int calcLineNum(int playerNum) {
        return playerNum * 2 - 1;
    }

    private void setLadder(int height, int lineNum) {
        for (int h = 0; h < height; h++) {
            ladder.add(new Line(lineNum));
        }
    }

    public String convertForViewMode() {
        StringBuilder builder = new StringBuilder();
        for (Line line : ladder) {
            builder.append(line.convertForViewMode())
                    .append("\n");
        }
        return builder.toString();
    }
}
