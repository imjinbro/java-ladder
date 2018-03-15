package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LineTest {
    private Line line;

    @Before
    public void setUp() throws Exception {
        ArrayList<Boolean> points = new ArrayList<>();
        points.addAll(Arrays.asList(true, true, true, false, true, true, true));
        line = new Line(points);
    }

    @Test
    public void 해당포지션_라인_그릴수있는지() {
        assertEquals(false, line.isDrawPosition(3));
        assertThat(line.isDrawPosition(3), is(false));
    }
}