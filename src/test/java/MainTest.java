import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void 플레이어_3명_올바르지않은가() {
        assertEquals(false, Main.isInvalidPlayerNum(3));
    }

    @Test
    public void 플레이어_마이너스1명_올바르지않은가() {
        assertEquals(true, Main.isInvalidPlayerNum(-1));
    }

    @Test
    public void 플레이어_이름5자초과_유효한이름인가() {
        assertEquals(false, Main.isValidNameLength("ABCDEF"));
    }

    @Test
    public void 사다리높이설정_2미만_유효하지않은가() {
        assertEquals(true, Main.isInvalidHeight(1));
    }

    @Test
    public void 플레이어들의_이름에_공백이있을경우_제거되는가() {
        String playersName = "jinbro, park, colin, abc";
        assertEquals("jinbro,park,colin,abc", Main.removeEmptySpace(playersName));
    }

    @Test
    public void 플레이어들의_이름이_입력되었을때_제대로_끊어내는가() {
        String playersName = Main.removeEmptySpace("jinbro, park, colin, abc");
        assertEquals(new String[]{"jinbro", "park", "colin", "abc"}, Main.dividePlayersName(playersName));
    }
}