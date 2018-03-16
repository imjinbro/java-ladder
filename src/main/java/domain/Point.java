package domain;

public class Point {
    private int position;
    private Direction direction;

    Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public boolean isMovablePosition() {
        return direction.canMoveLeft() || direction.canMoveDown() || direction.canMoveRight();
    }

    public boolean canMoveLeft() {
        return direction.canMoveLeft();
    }

    public boolean canMoveDown() {
        return direction.canMoveDown();
    }

    public boolean canMoveRight() {
        return direction.canMoveRight();
    }
}
