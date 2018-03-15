package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LadderMatcherTest {
    private Line lineUseLeft;
    private Line lineUseRight;

    @Before
    public void setUp() throws Exception {
        ArrayList<Boolean> points = new ArrayList<>(Arrays.asList(true, true, true, false, true));
        lineUseLeft = new Line(points);

        points = new ArrayList<>(Arrays.asList(true, false, true, true, true));
        lineUseRight = new Line(points);
    }

    @Test
    public void 사다리타기_같은줄에서_왼쪽으로_이동() {
        int startPosition = 2;
        assertThat(LadderMatcher.moveLeftPosition(lineUseLeft, startPosition), is(0));
    }

    @Test
    public void 사다리타기_같은줄에서_왼쪽으로_이동못함() {
        int startPosition = 4;
        assertThat(LadderMatcher.moveLeftPosition(lineUseLeft, startPosition), is(4));
    }

    @Test
    public void 사다리타기_같은줄에서_오른쪽으로_이동() {
        int startPosition = 2;
        int currentPositon = LadderMatcher.moveLeftPosition(lineUseRight, startPosition);
        assertThat(LadderMatcher.moveRightPosition(lineUseRight, startPosition, currentPositon), is(4));
    }

    @Test
    public void 사다리타기_같은줄에서_오른쪽으로_이동못함() {
        int startPosition = 0;
        int currentPositon = LadderMatcher.moveLeftPosition(lineUseRight, startPosition);
        assertThat(LadderMatcher.moveRightPosition(lineUseRight, startPosition, currentPositon), is(0));
    }
}