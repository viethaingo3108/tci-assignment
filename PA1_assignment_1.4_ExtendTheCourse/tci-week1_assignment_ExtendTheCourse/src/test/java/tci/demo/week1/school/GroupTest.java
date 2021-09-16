package tci.demo.week1.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class GroupTest {
    Group testGroup;
    private String VALID_GROUP_NAME = "E-S72";
    private int VALID_STUDENT_NUMBER = 12345;
    private String VALID_STUDENT_NAME = "Hai Ngo";

    @BeforeEach
    void setUp(){
        testGroup = new Group("E-S72");
    }

    @Test
    public void constructor_withValidParametersIsInitializedProperly(){
        assertThat(testGroup.getGroupName()).isEqualTo("E-S72");
    }

    @Test
    public void studentIsAddedCorrectly(){
        //Student student = new Student(VALID_STUDENT_NUMBER, VALID_STUDENT_NAME);
        Student student = mock(Student.class);

        testGroup.addStudent(student);
        assertTrue(testGroup.getStudentList().contains(student));
    }

    @Test
    public void mentorShouldBeSetCorrectly(){
        //define also Group and Student objects and also group.addStudent()
//        Student student = new Student(VALID_STUDENT_NUMBER, VALID_STUDENT_NAME);

        //arrange DOCs
        Student student1 = mock(Student.class);
        Student student2 = mock(Student.class);
        Student student3 = mock(Student.class);

        testGroup.addStudent(student1);
        testGroup.addStudent(student2);
        testGroup.addStudent(student3);

        //act
        String mentor = "Frank";
        testGroup.setMentor(mentor);

        //assert
        //assertEquals(student.getMentor(), mentor);
        verify(student1, description("Mentor was not set for student1")).setMentor(mentor);
        verify(student2, description("Mentor was not set for student2")).setMentor(mentor);
        verify(student3, description("Mentor was not set for student3")).setMentor(mentor);
    }

    @Test
    public void alreadyAddedStudentShouldThrowIAE(){
        //Student student = new Student(VALID_STUDENT_NUMBER, VALID_STUDENT_NAME);

        Student student = mock(Student.class);

        testGroup.addStudent(student);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           testGroup.addStudent(student);
        });
    }
}





















