package view;

import domain.*;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, Names names, Rewards rewards, int maxContentLength) {
        String ladderView = LadderViewBuilder.build(ladder, names, rewards, maxContentLength);
        System.out.println(ladderView);
    }

    // TODO : all 이라는 예외 상황도 생각해야함 : Names를 가져와야하나
    public static void viewResult(Results results, Name searchName) {
        //all 걸러내고

        Result result = results.searchResult(searchName);
        String resultView = ResultViewBuilder.build(result);
        System.out.println(resultView);
    }
}
