package ladder;

import ladder.util.LadderUtils;
import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    Line(int lineNum) {
        initPoints(lineNum);
    }

    private void initPoints(int lineNum) {
        ArrayList<Integer> drawPositions = getDrawPositions(lineNum);
        for (int pos = 0; pos < lineNum; pos++) {
            boolean canDraw = drawPositions.contains(pos);
            points.add(canDraw);
        }
    }

    private ArrayList<Integer> getDrawPositions(int lineNum) {
        ArrayList<Integer> drawPositions = new ArrayList<>();
        for (int pos = 0; pos < lineNum; pos++) {
            addDrawPositions(drawPositions, pos);
        }
        return drawPositions;
    }

    private void addDrawPositions(ArrayList<Integer> drawPositions, int pos) {
        if (LadderUtils.isEvenNumPos(pos)) {
            drawPositions.add(pos);
            return;
        }

        if (LadderUtils.selectDrawOrNotDraw() && !isExistAdjoinDrawPos(drawPositions, pos)) {
            drawPositions.add(pos);
        }
    }

    private boolean isExistAdjoinDrawPos(ArrayList<Integer> drawPositions, int pos) {
        return drawPositions.contains(pos - 2);
    }

    public boolean isDrawPosition(int position){
        return points.get(position);
    }
}
