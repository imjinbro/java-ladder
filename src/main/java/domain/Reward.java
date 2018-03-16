package domain;

public class Reward {
    private static final int MIN_REWARD_NAME_LENGTH = 1;
    private String rewardName;

    public Reward(String rewardName) {
        if (isInvalidRewardLength(rewardName)) {
            throw new IllegalArgumentException(MIN_REWARD_NAME_LENGTH + "자 이상 입력해야합니다");
        }
        this.rewardName = rewardName;
    }

    static boolean isInvalidRewardLength(String reward) {
        return MIN_REWARD_NAME_LENGTH > reward.length();
    }

    public String getRewardName() {
        return rewardName;
    }
}
