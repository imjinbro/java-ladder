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

    public boolean canLeftMove() {
        return direction.canMoveLeft();
    }

    public boolean canRightMove() {
        return direction.canMoveRight();
    }

    public int moveLeft() {
        return this.position - 1;
    }

    public int moveRight() {
        return this.position + 1;
    }
}
