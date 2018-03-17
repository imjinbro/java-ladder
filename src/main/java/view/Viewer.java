package view;

import domain.*;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, Names names, Rewards rewards) {
        String ladderView = LadderViewBuilder.build(ladder, names, rewards);
        System.out.println(ladderView);
    }

    public static void viewResult(Results results, Name searchName) {
        System.out.println(buildResultMessage(results, searchName));
    }

    private static String buildResultMessage(Results results, Name searchName) {
        if (isAllSearch(searchName)) {
            return ResultViewBuilder.build(results);
        }
        Result result = results.searchResult(searchName);
        return ResultViewBuilder.build(result);
    }

    private static boolean isAllSearch(Name searchName) {
        return searchName.equals(new Name("all"));
    }
}
