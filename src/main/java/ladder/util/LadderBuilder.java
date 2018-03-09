package ladder.util;

import ladder.Line;

import java.util.ArrayList;

public class LadderBuilder {
    public static String build(ArrayList<Line> ladder, String[] names) {
        StringBuilder builder = new StringBuilder();
        builder.append(LadderFormat.formatNames(names));

        for (int i = 0; i < ladder.size(); i++) {
            builder.append(buildLine(ladder.get(i), LadderUtils.calcLineNum(names.length)));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String buildLine(Line line, int pointNum) {
        StringBuilder builder = new StringBuilder();
        for (int position = 0; position < pointNum; position++) {
            boolean canDraw = line.isDrawPosition(position);
            builder.append(getLadderLetter(canDraw, position));
        }
        return LadderFormat.formatLine(builder.toString());
    }

    private static String getLadderLetter(boolean canDraw, int position) {
        if (isEvenNumPosition(position)) {
            return "|";
        }

        if (canDraw) {
            return "-----";
        }

        return "     ";
    }

    private static boolean isEvenNumPosition(int position) {
        return position % 2 == 0;
    }
}
