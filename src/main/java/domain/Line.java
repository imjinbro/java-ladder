package domain;

import java.util.ArrayList;

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
}
