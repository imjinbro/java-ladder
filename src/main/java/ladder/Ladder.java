package ladder;

import ladder.util.ViewMdeFormat;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();
    private String[] names;

    public Ladder(String[] names, int height) {
        this.names = names;
        setLadder(height, calcLineNum(names.length));
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
        builder.append(ViewMdeFormat.formatNames(names));
        builder.append("\n");

        for (Line line : ladder) {
            builder.append(line.convertForViewMode());
            builder.append("\n");
        }
        return builder.toString();
    }
}
