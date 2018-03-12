package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LineTest {
    private Line line;

    @Before
    public void setUp() throws Exception {
        ArrayList<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(true);
        points.add(true);
        points.add(false);
        points.add(true);
        points.add(true);
        points.add(true);
        line = new Line(points);
    }

    @Test
    public void 해당포지션_라인_그릴수있는지() {
        assertEquals(false, line.isDrawPosition(3));
    }
}