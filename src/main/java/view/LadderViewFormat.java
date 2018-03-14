package view;

import java.util.Arrays;

public class LadderViewFormat {
    public static String formatTab(String content, int maxContentLength) {
        return fillContentToArea(content.toCharArray(), maxContentLength);
    }

    private static String fillContentToArea(char[] content, int maxContentLength) {
        char[] area = new char[maxContentLength + 1];
        Arrays.fill(area, ' ');

        int fillTargetIdx = content.length - 1;
        for (int i = maxContentLength; (i >= 0 && fillTargetIdx >= 0); i--) {
            area[i] = content[fillTargetIdx--];
        }
        return String.valueOf(area);
    }

    public static String formatLine(String line, int maxNameLength) {
        char[] spacingArea = new char[maxNameLength];
        Arrays.fill(spacingArea, ' ');
        return String.valueOf(spacingArea) + line;
    }
}
