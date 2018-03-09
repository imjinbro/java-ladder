package ladder.util;

import java.util.Arrays;

public class ViewMdeFormat {
    private static final int MAX_LENGTH = 5;

    public static String formatNames(String[] names) {
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            builder.append(fillNameToArea(name.toCharArray()));
        }
        return builder.toString();
    }

    private static char[] fillNameToArea(char[] name) {
        char[] area = new char[MAX_LENGTH + 1];
        Arrays.fill(area, ' ');

        int fillTargetIdx = name.length - 1;
        for (int i = MAX_LENGTH; (i >= 0 && fillTargetIdx >= 0); i--) {
            area[i] = name[fillTargetIdx--];
        }
        return area;
    }

    public static String formatLine(String line) {
        char[] spacingArea = new char[MAX_LENGTH];
        Arrays.fill(spacingArea, ' ');
        return String.valueOf(spacingArea) + line;
    }
}
