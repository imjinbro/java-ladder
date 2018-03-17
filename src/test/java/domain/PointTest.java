package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PointTest {
    private Point point1;
    private Point point2;
    private Point point3;

    @Before
    public void setUp() throws Exception {
        ArrayList<Integer> movablePositions = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 6));
        Direction direction = LineCreator.createDirection(movablePositions, 1);
        point1 = new Point(1, direction);
        direction = LineCreator.createDirection(movablePositions, 3);
        point2 = new Point(3, direction);
        direction = LineCreator.createDirection(movablePositions, 6);
        point3 = new Point(6, direction);
    }

    @Test
    public void 두다리를_잇는_선_양쪽이동() {
        assertEquals(true, point1.canLeftMove());
        assertEquals(true, point1.canRightMove());
    }

    @Test
    public void 빈_포인트_이동불가능() {
        assertEquals(false, point2.isMovablePosition());
    }

    @Test
    public void 오른쪽끝_포인트_오른쪽이동_여부() {
        assertEquals(false, point3.canRightMove());
    }

    @Test
    public void 오른쪽끝_포인트_왼쪽이동_포지션() {
        assertEquals(5, point3.moveLeft());
    }
}