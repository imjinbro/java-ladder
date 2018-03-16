package view;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {
    private static final int MIN_PLAYER_NUM = 2;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int Min_HEIGHT = 2;

    @Test
    public void 플레이어들의_이름에_공백이있을경우_제거되는가() {
        String playersName = "jinbro, park, colin, abc";
        assertEquals("jinbro,park,colin,abc", Input.removeEmptySpace(playersName));
    }

    @Test
    public void 플레이어들의_이름이_입력되었을때_제대로_끊어내는가() {
        String playersName = Input.removeEmptySpace("jinbro, park, colin, abc");
        assertEquals(new String[]{"jinbro", "park", "colin", "abc"}, Input.divideUserInput(playersName));
    }
}