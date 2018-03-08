package io;

import ladder.Ladder;

public class Viewer {
    public static void viewMessage(String message) {
        System.out.println(message);
    }

    public static void viewLadder(Ladder ladder) {
        System.out.println(ladder.convertForViewMode());
    }
}
