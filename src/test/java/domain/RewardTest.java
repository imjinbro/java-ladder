package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RewardTest {
    @Test
    public void 리워드_이름1자이상() {
        assertEquals(false, Reward.isInvalidRewardLength("3000"));
    }

    @Test
    public void 리워드_이름_빈문자열() {
        assertEquals(true, Reward.isInvalidRewardLength(""));
    }
}