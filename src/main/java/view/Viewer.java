package view;

import domain.Ladder;
import domain.Names;
import domain.Rewards;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, Names names, Rewards rewards, int maxContentLength) {
        System.out.println(ladder.buildViewMode(names, rewards, maxContentLength));
    }

    public static void viewResult(Ladder ladder, Names names, Rewards rewards) {
        System.out.println(ladder.match(ladder, names, rewards));
    }
}
