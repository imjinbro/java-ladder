package domain;

import java.util.ArrayList;
import java.util.Optional;

public class Results {
    private ArrayList<Result> results = new ArrayList<>();

    public void addResult(String name, String reward) {
        Name wrapName = new Name(name);
        Reward wrapReward = new Reward(reward);
        Result result = new Result(wrapName, wrapReward);
        results.add(result);
    }

    public String getName(int position) {
        Result result = results.get(position);
        return result.getName();
    }

    public String getRewardName(int position) {
        Result result = results.get(position);
        return result.getReward();
    }

    public Result searchResult(Name searchName) {
        Optional<Result> search = results.stream()
                                         .filter(result -> result.isResultName(searchName))
                                         .findAny();
        return search.get();
    }

    public int getResultSize() {
        return results.size();
    }
}
