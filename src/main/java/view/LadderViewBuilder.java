package view;

import domain.*;

public class LadderViewBuilder {
    public static String build(Ladder ladder, Names names, Rewards rewards, int maxContentLength) {
        int playerNum = names.getPlayerNumber();

        return buildNameTab(names, playerNum, maxContentLength) +
                buildLadder(ladder, LadderUtils.calcPointNumOfLine(playerNum), maxContentLength) +
                buildRewardTab(rewards, playerNum, maxContentLength);
    }

    private static String buildRewardTab(Rewards rewards, int playerNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < playerNum; i++) {
            String formattedReward = LadderViewFormat.formatTab(rewards.getReward(i), maxContentLength);
            builder.append(formattedReward);
        }
        return builder.toString();
    }

    private static String buildNameTab(Names names, int playerNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < playerNum; i++) {
            String formattedName = LadderViewFormat.formatTab(names.getPlayerName(i), maxContentLength);
            builder.append(formattedName);
        }
        builder.append("\n");
        return builder.toString();
    }

    private static String buildLadder(Ladder ladder, int pointNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ladder.getHeight(); i++) {
            builder.append(buildLine(ladder.getLine(i), pointNum, maxContentLength));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String buildLine(Line line, int pointNum, int maxContentLength) {
        StringBuilder builder = new StringBuilder();

        for (int position = 0; position < pointNum; position++) {
            boolean canDraw = line.isDrawPosition(position);
            builder.append(buildLadderLetter(canDraw, position, maxContentLength));
        }
        return LadderViewFormat.formatLine(builder.toString(), maxContentLength);
    }

    static String buildLadderLetter(boolean canDraw, int position, int maxContentLength) {
        if (isEvenNumPosition(position)) {
            return "|";
        }

        if (canDraw) {
            return repeatLadderLetter('-', maxContentLength);
        }
        return repeatLadderLetter(' ', maxContentLength);
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
