package baseball.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    public void setUp() {
        referee = new Referee();
    }

    @DisplayName("투수의 투구, 타자의 스윙이 모두 일치하면 심판은 3스트라이크를 판단 테스트(TRUE 리턴)")
    @Test
    public void 심판_3스트라이크() {
        boolean result = referee.judge(new LinkedHashSet<>(Arrays.asList(1, 2, 3)),
                                       new LinkedHashSet<>(Arrays.asList(1, 2, 3)));
        assertThat(result).isTrue();
    }

    @DisplayName("투수의 투구, 타자의 스윙이 볼일경우 판단 테스트(FALSE 리턴)")
    @Test
    public void 심판_볼() {
        boolean result = referee.judge(new LinkedHashSet<>(Arrays.asList(1, 2, 3)),
                                       new LinkedHashSet<>(Arrays.asList(2, 5, 6)));
        assertThat(result).isFalse();
    }

    @DisplayName("투수의 투구, 타자의 스윙이 결과가 스트라이크, 볼일경우 판단 테스트(FALSE 리턴)")
    @Test
    public void 심판_스트라이크_볼() {
        boolean result = referee.judge(new LinkedHashSet<>(Arrays.asList(1, 2, 3)),
                                       new LinkedHashSet<>(Arrays.asList(1, 4, 2)));
        assertThat(result).isFalse();
    }

    @DisplayName("투수의 투구, 타자의 스윙이 결과가 낫싱일경우 판단 테스트(FALSE 리턴)")
    @Test
    public void 심판_낫싱() {
        boolean result = referee.judge(new LinkedHashSet<>(Arrays.asList(1, 2, 3)),
                                       new LinkedHashSet<>(Arrays.asList(5, 6, 7)));
        assertThat(result).isFalse();
    }
}
