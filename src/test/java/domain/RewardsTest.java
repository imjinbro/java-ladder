package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RewardsTest {

    @Test
    public void 리워드_4개_플레이어_4명() {
        assertEquals(false, Rewards.isInvalidRewardNum(new String[]{"a", "b", "c", "d"}, 4));
    }

    @Test
    public void 리워드_1개_플레이어_4명() {
        assertEquals(true, Rewards.isInvalidRewardNum(new String[]{"a"}, 4));
    }
}