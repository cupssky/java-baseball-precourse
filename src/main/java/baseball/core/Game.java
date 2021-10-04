package baseball.core;

import baseball.enums.RestartType;
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

  public void init() {
    start();
    end();
  }

  private void start() {
    Set<Integer> hitterSwing = hitter.swing();
    boolean end;
    do {
      end = referee.judge(hitterSwing, pitcher.throwBall());
    } while (!end);
  }

  private void end() {
    hitter.quit();

    MessageUtil.guideMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String restartCommand = Console.readLine();
    if (restartCommand.equals(RestartType.START.getValue())) {
      start();
    }
  }
}
