package baseball.exception;

public class GameException extends RuntimeException {
    public GameException() {
        super();
    }

    public GameException(String message) {
        super(message);
    }
}
