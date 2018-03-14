package domain;

public class Rewards {
    private String[] rewards;

    public Rewards(String[] rewards) {
        this.rewards = rewards;
    }

    public String getReward(int position) {
        return rewards[position];
    }
}
