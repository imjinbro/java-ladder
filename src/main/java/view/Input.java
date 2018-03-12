package view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        return scanner.nextInt();
    }

    public static String getPlayerNames() {
        return scanner.nextLine();
    }
}
