package tci.demo.week1.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A student is identified by studentNumber and name.
 * A student gets semester number 1 when enrolled for the first time (e.g., new regular bachelor students).
 * studentnumber never changes. the name can change.
 * Students can have a mentor, which can be changed later.
 * semesters range from 1..8
 * with a unique student number, consisting of 5 digits.
 */

class StudentTest {
    private static int validStudentNumber = 12345;
    private String validName = "Hai Ngo";

    @Test
    public void constructor_withValidParametersIsInitializedProperly(){
        Student student = new Student(validStudentNumber, validName);

        assertThat(student.getStudentNumber()).isEqualTo(validStudentNumber);
        assertThat(student.getName()).isEqualTo(validName);
    }

    @Test
    public void student_withSameStudentNumberAreLogicallyEqual(){
        Student A = new Student(validStudentNumber, validName);
        Student B = new Student(validStudentNumber,validName);

        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }

    @Test
    public void negativeStudentNumberShouldThrowIAE(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Student(-12345, validName);
        });
    }

    @Test
    public void nullNameShouldThrowIAE(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Student(validStudentNumber, null);
        });
    }

    @Test
    public void semesterNumberShouldBeSetFrom1To8(){
        Student student = new Student(validStudentNumber, validName);
        student.setSemesterNumber(8);
        assertThat(student.getSemesterNumber()).isEqualTo(8);
    }

    @Test
    public void semesterNumberOutsideOfRangeShouldThrowIAE(){
        Student student = new Student(validStudentNumber, validName);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            student.setSemesterNumber(9);
            student.setSemesterNumber(-1);
        });
    }

    @Test
    public void passedCourseShouldBeAddedCorrectly(){
        //arrange SUT
        Student student = new Student(validStudentNumber, validName);
//        Course course1 = new Course("Testing & Continuous Integration", "TCI", 3);
//        Course course2 = new Course("IT Operations", "ITO", 3); //week1

        //arrange DOCs
        Course course1 = mock(Course.class);
        when(course1.getCode()).thenReturn("TCI");
        Course course2 = mock(Course.class);
        when(course2.getCode()).thenReturn("PCS");

        //act
        student.addPassedCourse(course1);
        student.addPassedCourse(course2);

        //assert
        assertTrue(student.getPassedCourse().contains(course1));
        assertTrue(student.getPassedCourse().contains(course2));
    }

    @Test
    public void addAlreadyPassedCourseShouldThrowIAE(){
        Student student = new Student(validStudentNumber, validName);
        //Course course = new Course("IT Operations", "ITO", 3);

        Course course = mock(Course.class);
        when(course.getCode()).thenReturn("TCI");

        student.addPassedCourse(course);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            student.addPassedCourse(course);
        });
    }

    @Test
    public void passedCourseShouldBeRemovedCorrectly(){
        Student student = new Student(validStudentNumber, validName);
        //Course course = new Course("IT Operations", "ITO", 3);

        Course course = mock(Course.class);
        when(course.getCode()).thenReturn("TCI");

        student.addPassedCourse(course);
        try {
            student.removePassedCourse(course);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        assertFalse(student.getPassedCourse().contains(course));
    }

    @Test
    public void removeAlreadyRemovedPassedCourseShouldThrowIAE(){
        Student student = new Student(validStudentNumber, validName);
        //Course course = new Course("IT Operations", "ITO", 3);

        Course course = mock(Course.class);
        when(course.getCode()).thenReturn("TCI");

        assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> {
            student.removePassedCourse(course);
        });
    }

    @Test
    public void ecsShouldBeAddedCorrectly(){
        //arrange SUT
        Student student = new Student(validStudentNumber, validName);
//        Course c1 = new Course("Demo", "DMO", 3);
//        Course c2 = new Course("Database", "EDB", 4);

        //arrange DOCs
        Course c1 = mock(Course.class);
        when(c1.getEc()).thenReturn(3);
        when(c1.getCode()).thenReturn("TCI");
        Course c2 = mock(Course.class);
        when(c2.getEc()).thenReturn(4);
        when(c2.getCode()).thenReturn("PCS");

        //act
        student.addPassedCourse(c1);
        student.addPassedCourse(c2);

        int totalStudentEcs = student.getTotalECs();

        //assert
        assertThat(totalStudentEcs).isEqualTo(3+4);
    }

    @ParameterizedTest
    @MethodSource("generateStudentNumberWithInvalidSize")
    public void wrongSizeOfStudentNumberShouldThrowIAE(int studentNumber){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
           new Student(studentNumber, validName);
        });
    }

    private static Stream<Integer> generateStudentNumberWithInvalidSize(){
        return Stream.of(-12345,1, 12, 123, 1234, 123456);
    }

}












