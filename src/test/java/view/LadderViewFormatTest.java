package view;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderViewFormatTest {
    @Test
    public void 일정한_출력을_위해_플레이어이름_포맷팅_공백포함() {
        assertEquals(" colin", LadderViewFormat.formatName("colin", 5));
        assertEquals("   col", LadderViewFormat.formatName("col", 5));
    }

    @Test
    public void 일정한_출력을_위해_라인_포맷팅() {
        String line = "|-----|          |-----|";
        assertEquals("     |-----|          |-----|", LadderViewFormat.formatLine(line, 5));
    }
}