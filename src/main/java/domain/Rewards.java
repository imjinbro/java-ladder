package domain;

import java.util.ArrayList;

public class Rewards {
    private ArrayList<Reward> rewards = new ArrayList<>();

    public Rewards(String[] splitRewards, int rewardNum) throws IllegalArgumentException {
        if (isInvalidRewardNum(splitRewards, rewardNum)) {
            throw new IllegalArgumentException(rewardNum + "개 입력해야합니다");
        }

        for (String reward : splitRewards) {
            rewards.add(new Reward(reward));
        }
    }

    static boolean isInvalidRewardNum(String[] rewards, int playerNum) {
        return rewards.length != playerNum;
    }

    public String getReward(int position) {
        Reward searchReward = rewards.get(position);
        return searchReward.getRewardName();
    }
}
