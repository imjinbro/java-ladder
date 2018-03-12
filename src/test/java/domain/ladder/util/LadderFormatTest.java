package domain.ladder.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class LadderFormatTest {
    @Test
    public void 일정한_출력을_위해_플레이어이름_포맷팅_공백포함() {
        assertEquals(" colin", LadderFormat.formatName("colin", 5));
        assertEquals("   col", LadderFormat.formatName("col", 5));
    }

    @Test
    public void 일정한_출력을_위해_라인_포맷팅() {
        String line = "|-----|          |-----|";
        assertEquals("     |-----|          |-----|", LadderFormat.formatLine(line, 5));
    }
}