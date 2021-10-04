package baseball.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HitterTest {

    private Hitter hitter;

    @BeforeEach
    public void setUp() {
        hitter = new Hitter();
    }

    @DisplayName("타자 3개의 다른수 생성확인 테스트")
    @ValueSource(ints = 3)
    @ParameterizedTest
    public void 타자_3개_다른수_생성(int randomNumberCondition) {
        int swingNumberCount = hitter.swing().size();
        assertThat(swingNumberCount).isEqualTo(randomNumberCondition);
    }

}
