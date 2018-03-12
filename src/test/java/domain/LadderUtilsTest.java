package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderUtilsTest {
    @Test
    public void 사다리_1개라인의_지점개수_계산() {
        assertEquals(7, LadderUtils.calcPointNumOfLine(4));
    }
}