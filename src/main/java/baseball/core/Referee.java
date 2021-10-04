package baseball.core;

import baseball.constants.Const;
import baseball.utils.ConvertUtil;
import baseball.utils.MessageUtil;

import java.util.List;
import java.util.Set;

public class Referee {

    public boolean judge(Set<Integer> hitterSwing, Set<Integer> pitcherBall) {
        List<Integer> hitterSwingList = ConvertUtil.convertSetToList(hitterSwing);
        List<Integer> pitcherBallList = ConvertUtil.convertSetToList(pitcherBall);

        int strike = strike(hitterSwingList, pitcherBallList);
        int ball = ball(strike, hitterSwingList, pitcherBallList);

        MessageUtil.resultMessage(strike, ball);

        return strike == 3;
    }

    private int strike(List<Integer> hitterSwingList, List<Integer> pitcherBallList) {
        int strike = 0;
        for (int i = 0; i < Const.MAX_NUMBER_SIZE; i++) {
            int strikeCount = hitterSwingList.get(i).equals(pitcherBallList.get(i)) ? 1 : 0;
            strike += strikeCount;
        }
        return strike;
    }

    private int ball(int strike, List<Integer> hitterSwingList, List<Integer> pitcherBallList) {
        int ball = 0;
        for (int i = 0; i < Const.MAX_NUMBER_SIZE; i++) {
            int ballCount = pitcherBallList.contains(hitterSwingList.get(i)) ? 1 : 0;
            ball += ballCount;
        }
        return ball - strike;
    }
}
