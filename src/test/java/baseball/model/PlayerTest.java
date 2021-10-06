package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	private Player player;

	@BeforeEach
	void setup() {
		player = new Player();
	}

	@Test
	@DisplayName("문자열 123을 입력받으면 숫자 1, 2, 3으로 저장한다.")
	void playerNumber() {
		String inputNumber = "123";
		player.setPlayerNumber(inputNumber);
		assertThat(player.getPlayerNumber()).containsExactly(1, 2, 3);
	}

}
