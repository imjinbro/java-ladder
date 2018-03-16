package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    @Test
    public void 플레이어_이름5자이하() {
        assertEquals(false, Name.isInvalidLength("colin"));
    }

    @Test
    public void 플레이어_이름5자초과() {
        assertEquals(true, Name.isInvalidLength("imjinbro"));
    }
}