package domain;

import java.util.ArrayList;

public class LineCreator {

    static ArrayList<Point> createLine(int pointNum) {
        ArrayList<Integer> movablePositions = createMovablePositions(pointNum);
        ArrayList<Point> points = new ArrayList<>();
        for (int pos = 0; pos < pointNum; pos++) {
            Direction direction = createDirection(movablePositions, pos);
            Point point = new Point(pos, direction);
            points.add(point);
        }
        return points;
    }

    static Direction createDirection(ArrayList<Integer> movablePositions, int position) {
        if (!isMovablePosition(movablePositions, position)) {
            return Direction.valueOf(DirectionType.NOTMOVE);
        }

        if (position % 2 == 0) {
            return createDirectionEvenNum(movablePositions, position);
        }
        return createDirectionOddNum(movablePositions, position);
    }

    private static Direction createDirectionEvenNum(ArrayList<Integer> movablePositions, int position) {
        if (isMovablePosition(movablePositions, position - 1)) {
            return Direction.valueOf(DirectionType.LEFT);
        }

        if (isMovablePosition(movablePositions, position + 1)) {
            return Direction.valueOf(DirectionType.RIGHT);
        }
        return Direction.valueOf(DirectionType.DOWN);
    }


    private static Direction createDirectionOddNum(ArrayList<Integer> movablePositions, int position) {
        if (isMovablePosition(movablePositions, position - 1) && isMovablePosition(movablePositions, position + 1)) {
            return Direction.valueOf(DirectionType.BOTHSIDES);
        }

        if (isMovablePosition(movablePositions, position - 1)) {
            return Direction.valueOf(DirectionType.LEFT);
        }
        return Direction.valueOf(DirectionType.RIGHT);
    }

    private static boolean isMovablePosition(ArrayList<Integer> movablePositions, int position) {
        try {
            return movablePositions.contains(position);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    static ArrayList<Integer> createMovablePositions(int pointNum) {
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
