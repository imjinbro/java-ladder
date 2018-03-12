package view;

import domain.ladder.Ladder;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder, int maxNameLength) {
        System.out.println(ladder.buildLadder(maxNameLength));
    }
}
