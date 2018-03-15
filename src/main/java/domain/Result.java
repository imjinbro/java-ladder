package domain;

public class Result {
    private Name name;
    private Reward reward;

    Result(Name name, Reward reward) {
        this.name = name;
        this.reward = reward;
    }

    public String getName() {
        return name.getName();
    }

    public String getReward() {
        return reward.getRewardName();
    }

    public boolean isResultName(Name searchName) {
        return name.equals(searchName);
    }
}
