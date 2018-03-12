package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            int invalidData = -1;
            clearDummyData();
            return invalidData;
        }
    }

    private static void clearDummyData() {
        scanner.nextLine();
    }

    public static String getPlayerNames() {
        return scanner.nextLine();
    }
}
