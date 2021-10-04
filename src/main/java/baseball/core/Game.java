package baseball.core;

import baseball.enums.RestartType;
import baseball.enums.ResultCode;
import baseball.utils.MessageUtil;

import java.util.Set;

import nextstep.utils.Console;

public class Game {

    private Referee referee;
    private Hitter hitter;
    private Pitcher pitcher;

    public Game() {
        referee = new Referee();
        hitter = new Hitter();
        pitcher = new Pitcher();
    }

    public void start() {
        Set<Integer> hitterSwing = hitter.swing();
        boolean end;
        do {
            end = referee.judge(hitterSwing, pitcher.throwBall());
        } while (!end);
        hitter.quit();
        end();
    }

    private void end() {
        MessageUtil.guideMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        RestartType restartType = RestartType.findByValue(Console.readLine());
        if (restartType == RestartType.START) {
            start();
        }
        if (restartType == null) {
            MessageUtil.errorMessage(ResultCode.NOT_VALID_RESTART_TYPE);
            end();
        }
    }
}
