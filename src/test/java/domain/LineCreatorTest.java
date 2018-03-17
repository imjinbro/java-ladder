package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LineCreatorTest {
    private ArrayList<Integer> movablePositions;
    private ArrayList<Integer> movablePositions2;

    @Before
    public void setUp() throws Exception {
        movablePositions = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 6));
        movablePositions2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6));
    }

    @Test
    public void 왼쪽끝_옆라인있을때_아래이동() {
        Direction direction = LineCreator.createDirection(movablePositions, 0);
        assertEquals(false, direction.canMoveDown());
    }

    @Test
    public void 왼쪽끝_옆라인있을때_왼쪽이동() {
        Direction direction = LineCreator.createDirection(movablePositions, 0);
        assertEquals(false, direction.canMoveLeft());
    }

    @Test
    public void 왼쪽끝_옆라인없을때_아래이동() {
        Direction direction = LineCreator.createDirection(movablePositions2, 0);
        assertEquals(true, direction.canMoveDown());
    }
}