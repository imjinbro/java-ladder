package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private ArrayList<Point> points;

    Line(ArrayList<Point> points) {
        this.points = points;
    }

    public boolean isMovablePosition(int position) {
        Point point = points.get(position);
        return point.isMovablePosition();
    }

    public boolean isPlayerPosition(int position) {
        int pointIdxLimit = points.size();
        int spaceIdxTerm = 2;
        return (pointIdxLimit > position) && (position % spaceIdxTerm == 0);
    }

    public boolean isLimitPointNum(int pointIdx) {
        return points.size() == pointIdx;
    }

    public boolean canLeftMove(int position) {
        Point point = points.get(position);
        return point.canLeftMove();
    }

    public boolean canRightMove(int position) {
        Point point = points.get(position);
        return point.canRightMove();
    }

    public int moveLeft(int position) {
        Point point = points.get(position);
        return point.moveLeft();
    }

    public int moveRight(int position) {
        Point point = points.get(position);
        return point.moveRight();
    }
}
