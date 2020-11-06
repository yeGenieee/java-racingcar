package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void create_calculator_instance() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("입력 값이 null")
    void input_null() {
        assertThatThrownBy(() -> {
            calculator.input(null);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력값이 null이거나 빈 문자열");
    }

    @Test
    @DisplayName("입력 값이 빈 문자열")
    void input_empty_string() {
        assertThatThrownBy(() -> {
            calculator.input(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null이거나 빈 문자열");
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 아닌 경우")
    @ValueSource(strings = {"4 @ 7", "6 ) 2"})
    void input_not_arithmetic_operator(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아님");
    }

    @ParameterizedTest
    @DisplayName("계산기 기능 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "4 - 1 * 8 / 4=6"}, delimiter = '=')
    void calculate(String input, int expected) {
        assertEquals(calculator.calculate(input), expected);
    }
}