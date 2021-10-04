package baseball.core;

import java.util.Set;

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
    Set<Integer> swing = hitter.swing();
    boolean end;
    do {
      end = referee.judge(swing, pitcher.throwBall());
    } while (!end);
  }
}
