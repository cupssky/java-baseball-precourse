package baseball.view;

import baseball.config.GameMessage;
import baseball.model.Computer;

public class OutputView {
	private final Computer computer;

	public OutputView() {
		this.computer = new Computer();
	}

	/**
	 * 힌트 내용을 출력한다.
	 * @param hint 힌트 내용
	 */
	public void outputScore(String hint) {
		System.out.println(hint);
	}

	/**
	 * 게임 종료 메시지를 출력한다.
	 */
	public void quitMessage() {
		System.out.println(GameMessage.GAME_END_MESSAGE);
	}
}
