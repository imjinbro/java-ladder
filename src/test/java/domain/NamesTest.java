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

    @Test
    public void 중복된이름없음() {
        assertEquals(false, Names.searchDuplicateName(new String[]{"imjinbro", "colin"}));
    }

    @Test
    public void 중복된이름있음() {
        assertEquals(true, Names.searchDuplicateName(new String[]{"colin", "colin"}));
    }
}