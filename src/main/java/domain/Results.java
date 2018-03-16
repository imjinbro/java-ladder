package domain;

import java.util.ArrayList;

public class Results {
    private ArrayList<Result> results = new ArrayList<>();

    public void addResult(String name, String reward) {
        results.add(new Result(name, reward));
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
        return results.stream().filter(result -> result.isResultName(searchName)).findAny().get();
    }

    public int getResultSize() {
        return results.size();
    }
}
