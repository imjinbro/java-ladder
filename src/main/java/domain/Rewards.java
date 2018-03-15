package domain;

import java.util.ArrayList;

public class Rewards {
    private ArrayList<Reward> rewards = new ArrayList<>();

    public Rewards(String[] rewards) {
        initRewards(rewards);
    }

    private void initRewards(String[] splitRewards) {
        for (String reward : splitRewards) {
            rewards.add(new Reward(reward));
        }
    }

    public String getReward(int position) {
        Reward searchReward = rewards.get(position);
        return searchReward.getRewardName();
    }
}
