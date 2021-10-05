package baseball.model;

public class Game {
    private GameStatus gameStatus;

    public Game() {
        this.gameStatus = GameStatus.START;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
