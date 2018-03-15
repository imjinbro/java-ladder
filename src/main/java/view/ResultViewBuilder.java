package view;

import domain.*;

public class ResultViewBuilder {
    public static String build(Results results) {
        StringBuilder builder = new StringBuilder();
        builder.append("모든 플레이어 사다리 결과\n");
        for (int i = 0; i < results.getResultSize(); i++) {
            builder.append(results.getName(i) + " : " + results.getRewardName(i) + "\n");
        }
        return builder.toString();
    }

    public static String build(Result result) {
        return result.getName() + " 플레이어 사다리 결과 : " + result.getReward();
    }
}
