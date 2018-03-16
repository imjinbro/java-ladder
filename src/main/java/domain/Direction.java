package domain;

public class Direction {
    private boolean isLeft;
    private boolean isDown;
    private boolean isRight;

    private Direction(boolean isLeft, boolean isDown, boolean isRight) {
        this.isLeft = isLeft;
        this.isDown = isDown;
        this.isRight = isRight;
    }

    public static Direction valueOf(DirectionType type) {
        return new Direction(type.isLeft(), type.isDown(), type.isRight());
    }

    public boolean canMoveLeft() {
        return isLeft;
    }

    public boolean canMoveDown() {
        return isDown;
    }

    public boolean canMoveRight() {
        return isRight;
    }
}

enum DirectionType {
    NOTMOVE(false, false, false),
    LEFT(true, false, false),
    RIGHT(false, false, true),
    DOWN(false, true, false),
    BOTHSIDES(true, false, true);

    private boolean isLeft;
    private boolean isDown;
    private boolean isRight;

    DirectionType(boolean isLeft, boolean isDown, boolean isRight) {
        this.isLeft = isLeft;
        this.isDown = isDown;
        this.isRight = isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isDown() {
        return isDown;
    }

    public boolean isRight() {
        return isRight;
    }
}