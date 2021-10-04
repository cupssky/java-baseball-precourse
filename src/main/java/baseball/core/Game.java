package baseball.core;

public class Game {

  private Hitter hitter;

  public Game() {
    hitter = new Hitter();
  }

  public void start() {
    hitter.swing();
  }
}
