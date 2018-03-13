package view;

import domain.Ladder;
import domain.LadderUtils;
import domain.Line;
import domain.Names;

import java.util.ArrayList;

public class LadderViewBuilder {
    public static String build(Ladder ladder, Names names, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(buildNameTab(names, maxNameLength));
        builder.append("\n");

        for (int i = 0; i < ladder.getHeight(); i++) {
            builder.append(buildLine(ladder.getLine(i), LadderUtils.calcPointNumOfLine(names.getPlayerNumber()), maxNameLength));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String buildNameTab(Names names, int maxNameLength) {
        int playerNum = names.getPlayerNumber();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < playerNum; i++) {
            builder.append(LadderViewFormat.formatName(names.getPlayerName(i), maxNameLength));
        }
        return builder.toString();
    }

    private static String buildLine(Line line, int pointNum, int maxNameLength) {
        StringBuilder builder = new StringBuilder();

        for (int position = 0; position < pointNum; position++) {
            boolean canDraw = line.isDrawPosition(position);
            builder.append(buildLadderLetter(canDraw, position, maxNameLength));
        }
        return LadderViewFormat.formatLine(builder.toString(), maxNameLength);
    }

    static String buildLadderLetter(boolean canDraw, int position, int maxNameLength) {
        if (isEvenNumPosition(position)) {
            return "|";
        }

        if (canDraw) {
            return repeatLadderLetter('-', maxNameLength);
        }
        return repeatLadderLetter(' ', maxNameLength);
    }

    private static boolean isEvenNumPosition(int position) {
        return position % 2 == 0;
    }

    private static String repeatLadderLetter(char ladderLetter, int repeatNumber) {
        char[] result = new char[repeatNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = ladderLetter;
        }
        return String.valueOf(result);
    }
}
