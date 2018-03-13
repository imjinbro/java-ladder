package view;

import domain.Ladder;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, int maxNameLength) {
        System.out.println(ladder.buildViewMode(maxNameLength));
    }
}
