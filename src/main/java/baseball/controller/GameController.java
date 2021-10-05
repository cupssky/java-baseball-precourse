package baseball.controller;

import baseball.config.GameMessage;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.GameStatus;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer = new Computer();
    private Player player = new Player();
    private Game game = new Game();

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 게임 구동
     */
    public void run() {
        initGame();
        do {
            createGame();
            playGame();
        } while (game.getGameStatus().equals(GameStatus.START));
        showQuitMessage();
    }

    /**
     * 게임 상태를 초기화 한다.
     */
    private void initGame() {
        game.setGameStatus(GameStatus.START);
    }

    /**
     * 컴퓨터의 랜덤 숫자를 초기화 후 생성한다.
     */
    private void createGame() {
        computer.clearRandomNumber();
        computer.setRandomNumbers();
    }

    /**
     * 게임을 진행한다.
     */
    private void playGame() {
        do {
            inputPlayerNumber();
            showHint();
            checkThreeStrike();
        } while (game.getGameStatus().equals(GameStatus.START));

        restartGame();
    }

    /**
     * 플레이어에게 숫자를 입력받는다.
     */
    private void inputPlayerNumber() {
        String playerInputNumber = inputView.inputValue();

        player.clearPlayerNumber();
        player.setPlayerNumber(playerInputNumber);
    }

    /**
     * 힌트를 보여준다.
     */
    private void showHint() {
        String Hint = computer.makeHint(computer.getRandomNumbers(), player.getPlayerNumber());
        outputView.outputScore(Hint);
    }

    /**
     * 3스트라이크일 경우, 게임 상태를 "END"로 변경한다.
     */
    private void checkThreeStrike() {
        int strikeScore = computer.strikeScore(computer.getRandomNumbers(), player.getPlayerNumber());
        if (strikeScore == 3) {
            game.setGameStatus(GameStatus.END);
        }
    }

    /**
     * 게임 재시작을 위해서 상태를 변경한다.
     */
    private void restartGame() {
        String restartQuestionAsk = inputView.inputRestartQuestionAsk();
        if (restartQuestionAsk.equals(GameMessage.QUIT_NUMBER)) {
            game.setGameStatus(GameStatus.END);
        }

        if (restartQuestionAsk.equals(GameMessage.RESTART_NUMBER)) {
            game.setGameStatus(GameStatus.START);
        }
    }

    /**
     * 게임 종료 메시지를 보여준다.
     */
    private void showQuitMessage() {
        outputView.quitMessage();
    }

}
