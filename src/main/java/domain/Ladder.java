package domain;

import view.LadderViewBuilder;
import view.ResultViewBuilder;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int playerNum, int height) {
        setLadder(LadderUtils.calcPointNumOfLine(playerNum), height);
    }

    private void setLadder(int pointNum, int height) {
        for (int h = 0; h < height; h++) {
            ladder.add(new Line(LineCreator.create(pointNum)));
        }
    }

    public Line getLine(int height) {
        return ladder.get(height);
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getPointNum() {
        Line lastLine = ladder.get(ladder.size()-1);
        return lastLine.getPointNum();
    }

    public String buildViewMode(Names names, Rewards rewards, int maxContentLength) {
        return LadderViewBuilder.build(this, names, rewards, maxContentLength);
    }

    public String match(Ladder ladder, Names names, Rewards rewards) {
        /*리턴값 = LadderMatcher.match(ladder, names, rewards);
        return 매치결과메세지만드는애.만들어줘(리턴값);*/
        LadderMatcher.match(ladder, names, rewards);
        return ResultViewBuilder.build();
    }
}
