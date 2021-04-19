package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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

}