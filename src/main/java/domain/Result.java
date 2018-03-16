package domain;

public class Result {
    private Name name;
    private Reward reward;

    Result(String name, String reward) {
        this.name = new Name(name);
        this.reward = new Reward(reward);
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
