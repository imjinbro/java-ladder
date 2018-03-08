package ladder;

import ladder.util.LadderUtils;

import java.util.ArrayList;

public class Ladder {
    private boolean[][] ladder;
    private int heightLimit;
    private int lineNum;

    public Ladder(int playerNum, int height) {
        this.heightLimit = height;
        this.lineNum = calcLineNum(playerNum);

        initLadder();
        setLadder();
    }

    private int calcLineNum(int playerNum){
        return playerNum*2-1;
    }

    private void initLadder(){
        ladder = new boolean[heightLimit][lineNum];
    }

    private void setLadder(){
        for (int height = 0; height < heightLimit; height++) {
            setEachHeight(height);
        }
    }

    private void setEachHeight(int height) {
        ArrayList<Integer> drawPositions = getDrawPositions();
        boolean[] points = new boolean[lineNum];

        for (int pos = 0; pos< lineNum; pos++) {
            points[pos] = drawPositions.contains(pos);
        }

        ladder[height] = points;
    }

    private ArrayList<Integer> getDrawPositions() {
        ArrayList<Integer> drawPositions = new ArrayList<>();
        for (int pos = 0; pos < lineNum; pos++) {
            addDrawPositions(drawPositions, pos);
        }
        return drawPositions;
    }

    private void addDrawPositions(ArrayList<Integer> drawPositions, int pos) {
        if(LadderUtils.isEvenNumPos(pos)){
            drawPositions.add(pos);
            return;
        }

        if(LadderUtils.choiceDraw() && !isExistAdjoinDrawPos(drawPositions, pos)) {
            drawPositions.add(pos);
        }
    }


    private boolean isExistAdjoinDrawPos(ArrayList<Integer> drawPositions, int pos) {
        return drawPositions.contains(pos-2);
    }


    public String convertToViewMode() {
        StringBuilder builder = new StringBuilder();
        for (boolean[] points : ladder) {
            builder.append(convertEachHeight(points)).append("\n");
        }
        return builder.toString();
    }

    private String convertEachHeight(boolean[] points) {
        StringBuilder builder = new StringBuilder();
        for (int pos = 0; pos < lineNum; pos++) {
            builder.append(convertPoint(pos, points[pos]));
        }
        return builder.toString();
    }

    private char convertPoint(int pos, boolean point) {
        if (LadderUtils.isEvenNumPos(pos)) {
            return '|';
        }

        if(point){
            return '-';
        }
        return ' ';
    }
}
