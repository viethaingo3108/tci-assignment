import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringReverseTest {

    @Test
    void nullStringShouldThrowNullPointerException(){
        StringReverse s = new StringReverse();
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(()->{
            s.reverse(null);
        });
    }

    @ParameterizedTest
    @MethodSource("reverseValues")
    void stringShouldBeReversedProperly(String input, String output){
        StringReverse s = new StringReverse();
        assertThat(output).isEqualTo(s.reverse(input));
        //assertEquals(output, s.reverse(input));
    }

    private Object[] reverseValues(){
        return new Object[]{
                new Object[]{"abc", "cba"},
                new Object[]{"",""}
        };
    }
}