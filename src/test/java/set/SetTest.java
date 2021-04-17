package set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetTest {
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
    @DisplayName("요구사항1 - size() 메소드로 Set의 크기를 확인하는 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항2 - contains()로 1,2,3 의 값이 존재하는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("요구사항3 - 입력 값에 따라 결과 값이 다른 경우도 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void check_if_contains(Integer input, boolean expected) {
        boolean actualResult = numbers.contains(input);
        assertThat(expected).isEqualTo(actualResult);
    }

}
