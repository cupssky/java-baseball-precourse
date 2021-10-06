package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("1. Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
	void checkSetSize() {
		int size = numbers.size();

		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("2. contains() 메소드와 JUnit의 ParameterizedTest를 활용해 1,2,3의 값이 존재하는지 확인한다.")
	@ValueSource(ints = {1, 2, 3})
	void checkContainsValue(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("3. contains() 메소드 실행 결과 1,2,3 은 true, 4,5는 false 가 반환된다.")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void removeDuplicationNumber(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
