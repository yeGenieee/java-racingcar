package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void create_string_calculator_instance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력 값이 null인 경우 테스트")
    void input_null() {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null 이거나 빈 문자열");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 빈 문자열인 경우 테스트")
    @ValueSource(strings = {"", "  "})
    void input_blank(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null 이거나 빈 문자열");
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 아닌 경우 테스트")
    @ValueSource(strings = {"2 @ 3 + 3", "1 * 4 ^ 7"})
    void input_non_arithmetic_operator(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아님");
    }

}