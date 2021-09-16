package tci.demo.week1.school;

import java.util.Objects;

/**
 * A Course is an IMMUTABLE object with a given name, code and ec.
 * It's uniquely identified by it's course code (a string).
 * the name of the course (a string) should not be null
 * code should be 3 or 4 characters long and is in upper case
 * the number of EC's (ec) is a positive whole number.
 * If above parametes are wrong, an IllegalArgumentException should be thrown during construction.
 */
public class Course {
    // TODO: You should already have tests and code for this class in the "I dare you" assignment.
    private String name;
    private String code;
    private int ec;

    public Course(String name, String code, int ec) throws IllegalArgumentException{
        if(name == null){
            throw new IllegalArgumentException("Name should not be null");
        }
        if(code == null){
            throw new IllegalArgumentException("Code should not be null");
        }
        if(ec < 0){
            throw new IllegalArgumentException("EC should not be negative");
        }
        if(code.length() < 3 || code.length() > 4){
            throw new IllegalArgumentException("Code should be 3 or 4 characters long");
        }
        if(!code.toUpperCase().equals(code)){
            throw new IllegalArgumentException("Code should be all in uppercase");
        }

        this.name = name;
        this.code = code;
        this.ec = ec;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getEc() {
        return ec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getEc() == course.getEc() && getName().equals(course.getName()) && getCode().equals(course.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCode(), getEc());
    }
}

/*
 *
 * Note: An IMMUTABLE object is mostly used for transfering data between layers in your software
 * , so it only has a constructor which sets ALL attributes, and it has getters (generated by the IDE)
 * for all of the attributes.
 * (this is a so called DTO: Data Transfer Object)
 *
 *
 */

