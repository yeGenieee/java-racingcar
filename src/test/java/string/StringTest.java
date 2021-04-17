package string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {


    @Test
    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    void split() {
        String input = "1,2";

        assertThat(input.split(",")).contains("1");
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring() 결과가 \"1,2\"인지 테스트")
    void substring() {
        String input = "(1,2)";

        assertThat(input.substring(1,input.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 통해 특정 위치의 문자를 가져오는지 테스트")
    void charAt() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나는 경우 예외를 발생시키는지 테스트")
    void charAt_out_of_bounds() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
