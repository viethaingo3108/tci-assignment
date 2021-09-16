package tci.demo.week1.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * A Course is an IMMUTABLE object with a given name, code and ec.
 * It's uniquely identified by it's course code (a string).
 * the name of the course (a string) should not be null
 * code should be 3 or 4 characters long and is in upper case
 * the number of EC's (ec) is a positive whole number.
 * If above parametes are wrong, an IllegalArgumentException should be thrown during construction.
 */
class CourseTest {
    private static String validName = "Testing and Continuous Integration";
    private static String validCode = "TCI";
    private static int validEC = 3;

    /**
     * assertThat() can be replaced by assertEquals() instead
     * */
    @Test
    public void constructor_withValidParametersIsInitializedProperly(){
        Course course = new Course(validName, validCode, validEC);

        assertThat(course.getName()).isEqualTo(validName);
        assertThat(course.getCode()).isEqualTo(validCode);
        assertThat(course.getEc()).isEqualTo(validEC);
    }

    @Test
    public void nullNameShouldThrowIAE(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(null, validCode, validEC);
        });
    }

    @Test
    public void nullCodeShouldThrowIAE(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(validName, null, validEC);
        });
    }

    @Test
    public void negativeECShouldThrowIAE(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(validName, validCode, -3);
        });
    }

    @ParameterizedTest
    @MethodSource("generateCodeWithInvalidSize")
    public void wrongSizeOfCodeShouldThrowIAE(String code){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            new Course(validName, code, validEC);
        });
    }

    private static Stream<String> generateCodeWithInvalidSize(){
        return Stream.of("", "A", "AB", "ab", "abcd", "ABCd", "abc", "aBC", "ABCDE", "abcde");
    }

    @Test
    public void course_withSameCodesAreLogicallyEqual(){
        Course A = new Course(validName, validCode, validEC);
        Course B = new Course(validName, validCode, validEC);

        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }
}


















