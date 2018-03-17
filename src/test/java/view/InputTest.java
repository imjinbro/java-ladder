package view;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void 공백과_쉼표_제거_잘되는가() {
        String playersName = "jinbro, park, colin, abc";
        assertEquals(new String[]{"jinbro", "park", "colin", "abc"}, Input.divideUserInput(playersName));
    }
}