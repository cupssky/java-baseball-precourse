package baseball.view;

import baseball.config.BallConfig;
import baseball.config.GameMessage;
import baseball.exception.GameException;
import nextstep.utils.Console;

public class InputView extends GameException {

	/**
	 * Player의 랜덤 숫자 입력값 받아오기 <br/>
	 * 오류 발생 시 Error 메시지 출력 후 계속 진행한다.
	 * @return String
	 */
	public String inputValue() {
		String inputNumber;
		do {
			System.out.print(GameMessage.INPUT_MESSAGE);
			inputNumber = Console.readLine();
		} while (!checkInputValueValication(inputNumber));

		return inputNumber;
	}

	/**
	 * 재시작 질문에 대한 답변 입력값 받아오기
	 * @return String
	 */
	public String inputRestartQuestionAsk() {
		System.out.println(GameMessage.GAME_RESTART_QUESTION_MESSAGE);
		return Console.readLine();
	}

	/**
	 * 입력값에 대한 유효성 검사
	 * @param inputValue 입력값
	 * @return boolean
	 */
	public boolean checkInputValueValication(String inputValue) {
		try {
			checkNumberLength(inputValue);
			checkOnlyNumber(inputValue);
			checkNumberScope(inputValue);
		} catch (Exception e) {
			System.err.println("checkInputValueValication() Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 입력값이 숫자가 아니면 오류를 반환한다.
	 * @param inputValue 입력값
	 */
	private void checkOnlyNumber(String inputValue) {
		if (!inputValue.matches("[0-9]+")) {
			throw new GameException(GameMessage.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
		}
	}

	/**
	 * 입력값이 갯수가 INPUT_SIZE와 다르면 오류를 반환한다.
	 * @param inputValue 입력값
	 */
	private void checkNumberLength(String inputValue) {
		if (inputValue.length() != BallConfig.INPUT_SIZE) {
			throw new GameException(GameMessage.ERROR_MESSAGE_INPUT_NUMBER_LENGTH);
		}
	}

	/**
	 * 입력값 숫자의 범위를 체크한다.
	 * @param inputValue 입력값
	 */
	private void checkNumberScope(String inputValue) {
		for (int i = 0; i < inputValue.length(); i++) {
			isNumberInScope(inputValue.charAt(i));
		}
	}

	/**
	 * 입력값이 정해진 범위에서 벗어나면 오류를 반환한다.
	 * @param charAt 특정 위치의 입력값
	 */
	private void isNumberInScope(char charAt) {
		if (charAt - '0' < BallConfig.MIN_NUMBER || charAt - '0' > BallConfig.MAX_NUMBER) {
			throw new GameException(GameMessage.ERROR_MESSAGE_INPUT_NUMBER_SCOPE);
		}
	}
}
