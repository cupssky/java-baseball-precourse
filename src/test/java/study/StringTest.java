package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    @DisplayName("1-1. \"1,2\"을 ,로 split했을 때 1과 2로 분리된다.")
    void splitTwoNumber() {
        // given
        String twoNumber = "1,2";

        // when
        String[] splitNumber = twoNumber.split(",");

        // then
        assertThat(splitNumber).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1-2. \"1\"을 ,로 split했을 때 1만을 포함하는 배열이 반환된다.")
    void splitOneNumber() {
        // given
        String oneNumber = "1";

        // when
        String[] splitNumber = oneNumber.split(",");

        // then
        assertThat(splitNumber).containsExactly("1");

    }

    @Test
    @DisplayName("2. \"(1,2)\" 값이 주어졌을 때 substring() 메소드를 이용해 ()를 제거하고 \"1,2\"를 반환한다.")
    void removeStringBySubstring() {
        // given
        String string = "(1,2)";

        // when
        String result = string.substring(string.indexOf("(")+1, string.lastIndexOf(")"));

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("3-1. \"abc\"값이 주여졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void getCharacterByCharAt() {
        // given
        String word = "abc";

        // when
        char alphabet = word.charAt(0);

        // then
        assertThat(alphabet).isEqualTo('a');
    }

    @Test
    @DisplayName("3-2. charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void getCharacterByCharAtException() {
        // given
        String word = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            char alphabet = word.charAt(word.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: " + word.length());
    }
}
