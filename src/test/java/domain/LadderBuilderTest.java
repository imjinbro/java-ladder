package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderBuilderTest {
    @Test
    public void 홀수포지션_라인빌드() {
        assertEquals("-----", LadderBuilder.buildLadderLetter(true, 1, 5));
    }

    @Test
    public void 짝수포지션_라인빌드() {
        assertEquals("|", LadderBuilder.buildLadderLetter(true, 0, 5));
    }
}