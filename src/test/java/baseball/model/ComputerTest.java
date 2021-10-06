package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	private Computer computer;
	private Player player;

	@BeforeEach
	void setup() {
		computer = new Computer();
		player = new Player();
	}

	@Test
	@DisplayName("랜덤으로 생성된 숫자들의 개수가 3개이다.")
	void numberSize() {
		computer.setRandomNumbers();
		assertThat(computer.getRandomNumbers().size()).isEqualTo(3);
	}

	@Test
	@DisplayName("랜덤으로 생성된 숫자들이 1~9 사이에 있다.")
	void isRandomNumber() {
		computer.setRandomNumbers();
		assertThat(computer.getRandomNumbers()
			.stream()
			.allMatch(number -> number >= 1 && number <= 9)).isTrue();
	}

	@Test
	@DisplayName("숫자들을 중복체크한다.")
	void checkDuplicationNumber() {
		computer.addRandomNumbers(1);
		computer.addRandomNumbers(2);
		assertThat(computer.isDuplication(2)).isTrue();
	}

	@Test
	@DisplayName("컴퓨터의 수가 425일 때, 123을 제시한 경우 스트라이크의 점수는 1이다.")
	void isStrike() {
		computer.addRandomNumbers(4);
		computer.addRandomNumbers(2);
		computer.addRandomNumbers(5);

		player.setPlayerNumber("123");

		assertThat(computer.strikeScore(computer.getRandomNumbers(), player.getPlayerNumber())).isEqualTo(1);
	}

	@Test
	@DisplayName("컴퓨터의 수가 425일 때, 456을 제시한 경우 볼의 점수는 1이다.")
	void isBall() {
		computer.addRandomNumbers(4);
		computer.addRandomNumbers(2);
		computer.addRandomNumbers(5);

		player.setPlayerNumber("456");

		assertThat(computer.ballScore(computer.getRandomNumbers(), player.getPlayerNumber())).isEqualTo(1);
	}

	@Test
	@DisplayName("컴퓨터의 수가 425일 때, 789을 제시한 경우 낫싱이다.")
	void isNothing() {
		computer.addRandomNumbers(4);
		computer.addRandomNumbers(2);
		computer.addRandomNumbers(5);

		player.setPlayerNumber("789");

		int strikeScore = computer.strikeScore(computer.getRandomNumbers(), player.getPlayerNumber());
		int ballScore = computer.ballScore(computer.getRandomNumbers(), player.getPlayerNumber());

		assertThat(strikeScore + ballScore).isEqualTo(0);
	}
}