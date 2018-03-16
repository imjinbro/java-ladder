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
}
