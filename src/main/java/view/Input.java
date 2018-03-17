package view;

import domain.Names;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getHeight(String printMessage) throws NumberFormatException {
        Viewer.viewMessage(printMessage);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    public static String[] getPlayerNames(String printMessage) {
        Viewer.viewMessage(printMessage);
        return divideUserInput(scanner.nextLine());
    }

    static String[] divideUserInput(String playersName) {
        return playersName.split(",\\s*");
    }

    public static String[] getRewards(String printMessage) {
        Viewer.viewMessage(printMessage);
        return divideUserInput(scanner.nextLine());
    }

    public static String getResultName(Names names, String exitKey) {
        String input = scanner.nextLine();
        while (!input.equals(exitKey) && !input.equals("all") && !names.isExistName(input)) {
            Viewer.viewMessage("참여하지 않은 플레이어입니다.");
            input = getResultName(names, exitKey);
        }
        return input;
    }
}
