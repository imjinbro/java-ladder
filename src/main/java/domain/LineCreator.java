package domain;

import java.util.ArrayList;

public class LineCreator {
    public static ArrayList<Boolean> create(int pointNum) {
        ArrayList<Boolean> points = new ArrayList<>();
        ArrayList<Integer> drawPositions = getDrawPositions(pointNum);
        for (int pos = 0; pos < pointNum; pos++) {
            points.add(isDrawPosition(pos, drawPositions));
        }
        return points;
    }

    private static boolean isDrawPosition(int position, ArrayList<Integer> drawPositions) {
        return drawPositions.contains(position);
    }

    private static ArrayList<Integer> getDrawPositions(int pointNum) {
        ArrayList<Integer> drawPositions = new ArrayList<>();
        for (int pos = 0; pos < pointNum; pos++) {
            addDrawPositions(drawPositions, pos);
        }
        return drawPositions;
    }

    private static void addDrawPositions(ArrayList<Integer> drawPositions, int pos) {
        if (LadderUtils.isEvenNumPos(pos)) {
            drawPositions.add(pos);
            return;
        }

        if (LadderUtils.selectDrawOrNotDraw() && !isExistAdjoinDrawPos(drawPositions, pos)) {
            drawPositions.add(pos);
        }
    }

    private static boolean isExistAdjoinDrawPos(ArrayList<Integer> drawPositions, int pos) {
        int posDiff = 2;
        return drawPositions.contains(pos - posDiff);
    }
}
