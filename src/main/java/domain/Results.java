package domain;

import java.util.ArrayList;

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
        return result.getName();
    }

    //또다른 Results를 만들어야하나?
    public Result searchResult(Name searchName) {
        Result targetResult = null;
        for (Result result : results) {
            if(result.isResultName(searchName)) {
                targetResult = result;
                break;
            }
        }
        return targetResult;
    }

    public int getResultSize() {
        return results.size();
    }
}
