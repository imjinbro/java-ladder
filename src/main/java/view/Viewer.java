package view;

import domain.Ladder;
import domain.Names;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, Names names, int maxNameLength) {
        System.out.println(ladder.buildViewMode(names, maxNameLength));
    }
}
