package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void 아래로만_방향만_갈수있는_인스턴스_생성() {
        Direction direction = Direction.valueOf(DirectionType.DOWN);
        assertEquals(false, direction.canMoveLeft());
        assertEquals(true, direction.canMoveDown());
        assertEquals(false, direction.canMoveRight());
    }

    @Test
    public void 왼쪽으로만_방향만_갈수있는_인스턴스_생성() {
        Direction direction = Direction.valueOf(DirectionType.LEFT);
        assertEquals(true, direction.canMoveLeft());
        assertEquals(false, direction.canMoveDown());
        assertEquals(false, direction.canMoveRight());
    }
}