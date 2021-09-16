package tci.demo.week1.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Group represents a group of unique students, e.g. a class e-s72,
 * and is uniquely identified by it's name.
 * When a group has no name yet, it automatically is given
 * the temporary name "unknown". The name can be changed later.
 * a student can be added to a group. A mentor can be added to the group, in this case, all students
 * get assigned this mentor
 *
 */
public class Group {

    // TODO
    private String groupName;
    private List<Student> studentList = new ArrayList<>();
    private String mentorName;

    /**
     * Creates a group with a default name "unknown"
     */
    public Group() {
        // TODO
        groupName = "unknown";
    }

    /**
     * Creates a Group object with a given name.
     * @param name is the name of the group/class, e.g., "e-s72"
     */
    public Group(String name) {
        // TODO
        groupName = name;
    }


    /**
     * Add a student to the group
     * @param student Student to add
     */
    public void addStudent(Student student){
        // TODO
        if(student!= null && !studentList.contains(student))
        {studentList.add(student);}
        else{
            throw new IllegalArgumentException("Student already in the group");
        }
    }

    /**
     * Assigns a mentor to all students in this group
     * @param mentor is the mentor of the group
     */
    public void setMentor(String mentor){
        // TODO
        for(Student s: studentList){
            s.setMentor(mentor);
        }
    }


    /******************************************************
     *
     *   GETTERS/SETTERS CODE IS GENERATED BY INTELLIJ,
     *   AND UNTOUCHED BY PEOPLE.
     *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
     *
     ********************************************************/

    // TODO

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

//    public String getMentorName() {
//        return mentorName;
//    }


    /******************************************************
     *
     *   OTHER CODE GENERATED BY INTELLIJ,
     *   BUT BASED ON INPUT OF A PROGRAMMER.
     *   THE BEHAVIOUR OF THIS CODE HAS TO BE TESTED.
     *   (but not present to keep demo code short)
     *
     ********************************************************/

    // TODO


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getGroupName().equals(group.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupName());
    }
}
