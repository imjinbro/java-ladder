package view;

import java.util.Arrays;

public class LadderViewFormat {
    public static String formatName(String name, int maxNameLength) {
        return fillNameToArea(name.toCharArray(), maxNameLength);
    }

    private static String fillNameToArea(char[] name, int maxNameLength) {
        char[] area = new char[maxNameLength + 1];
        Arrays.fill(area, ' ');

        int fillTargetIdx = name.length - 1;
        for (int i = maxNameLength; (i >= 0 && fillTargetIdx >= 0); i--) {
            area[i] = name[fillTargetIdx--];
        }
        return String.valueOf(area);
    }

    public static String formatLine(String line, int maxNameLength) {
        char[] spacingArea = new char[maxNameLength];
        Arrays.fill(spacingArea, ' ');
        return String.valueOf(spacingArea) + line;
    }
}
