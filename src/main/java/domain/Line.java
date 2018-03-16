package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private ArrayList<Boolean> points;

    Line(ArrayList<Boolean> points) {
        this.points = points;
    }

    public boolean isDrawPosition(int position) {
        return points.get(position);
    }

    public boolean canMove(int nextPosition) {
        try {
            return isDrawPosition(nextPosition);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public ArrayList<Integer> getPlayerPositions() {
        int size = points.size();
        return IntStream.range(0, size).filter(i -> i % 2 == 0).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
