package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NamesTest {

    @Test
    public void 플레이어4명() {
        assertEquals(false, Names.isInvalidPlayerNum(new String[]{"a", "b", "c", "d"}));
    }

    @Test
    public void 플레이어1명() {
        assertEquals(true, Names.isInvalidPlayerNum(new String[]{"a"}));
    }
}