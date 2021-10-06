package baseball.config;

public class GameMessage {
	public static final String STRIKE = "스트라이크 ";
	public static final String BALL = "볼";
	public static final String NOTHING = "낫싱";
	public static final String RESTART_NUMBER = "1";
	public static final String QUIT_NUMBER = "2";
	public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String GAME_END_MESSAGE = BallConfig.INPUT_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String GAME_RESTART_QUESTION_MESSAGE =
		"게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + QUIT_NUMBER + "를 입력하세요.";
	public static final String ERROR_MESSAGE_INPUT_DUPLICATION_VALUE = "[ERROR] 중복된 값을 입력하였습니다. 다시 입력해주세요.";
	public static final String ERROR_MESSAGE_INPUT_NUMBER_LENGTH =
		"[ERROR] " + BallConfig.INPUT_SIZE + "자리 숫자만 입력 가능합니다. 다시 입력해주세요.";
	public static final String ERROR_MESSAGE_INPUT_NUMBER_SCOPE =
		"[ERROR] " + BallConfig.MIN_NUMBER + "부터 " + BallConfig.MAX_NUMBER + "까지의 숫자만 입력 가능합니다. 다시 입력해주세요.";
	public static final String ERROR_MESSAGE_INPUT_ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.";
}
