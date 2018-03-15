package view;

import domain.*;

public class ResultViewBuilder {
    public static String build(Results results) {

        return null;
    }

    public static String build(Result result) {
        return result.getName() + " 플레이어 사다리 결과 : " + result.getReward();
    }
}
