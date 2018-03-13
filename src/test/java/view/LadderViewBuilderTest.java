package view;

import org.junit.Test;

import static org.junit.Assert.*;

public class LadderViewBuilderTest {
    @Test
    public void 홀수포지션_라인빌드() {
        assertEquals("-----", LadderViewBuilder.buildLadderLetter(true, 1, 5));
    }

    @Test
    public void 짝수포지션_라인빌드() {
        assertEquals("|", LadderViewBuilder.buildLadderLetter(true, 0, 5));
    }
}