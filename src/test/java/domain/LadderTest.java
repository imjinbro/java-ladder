package domain;

import org.junit.Test;
import view.Input;

import static org.junit.Assert.*;

public class LadderTest {

    @Test
    public void 사다리높이설정_2이상() {
        assertEquals(false, Ladder.isInvalidHeight(5));
    }

    @Test
    public void 사다리높이설정_2미만() {
        assertEquals(true, Ladder.isInvalidHeight(1));
    }
}