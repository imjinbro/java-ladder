package domain;

public class Result {
    private int playerNum;
    private int resultNum;

    public Result(int playerNum, int resultNum) {
        this.playerNum = playerNum;
        this.resultNum = resultNum;
    }

    //임시
    public int getPlayerNum() {
        return playerNum;
    }

    public int getResultNum() {
        return resultNum;
    }
}
