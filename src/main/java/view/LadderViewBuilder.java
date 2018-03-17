package view;

import domain.*;

public class LadderViewBuilder {
    public static String build(Ladder ladder, Names names, Rewards rewards) {
        int playerNum = names.getPlayerNumber();
        int maxContentLength = names.getMaxNameLength();

        return buildNameTab(names, playerNum, maxContentLength) +
                buildLadder(ladder, maxContentLength) +
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

    private static String buildLadder(Ladder ladder, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        int heightIdx = 0;
        while (!ladder.isMaxHeight(heightIdx)) {
            builder.append(buildLine(ladder, heightIdx, maxContentLength));
            builder.append("\n");
            heightIdx = ladder.moveDown(heightIdx);
        }
        return builder.toString();
    }

    private static String buildLine(Ladder ladder, int heightIdx, int maxContentLength) {
        StringBuilder builder = new StringBuilder();
        int position = 0;
        while (!ladder.isLimitPointNum(position)) {
            boolean canDraw = ladder.isMovablePosition(heightIdx, position);
            builder.append(buildLadderLetter(canDraw, position, maxContentLength));
            position++;
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
