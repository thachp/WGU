package edu.wgu.c169;
import java.util.Arrays;

/**
 * Created by pthach2 on 1/23/16.
 */

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int[] grades;

    /**
     * Accessor (i.e., getter) for each instance variable from part B1
     */

    public int getStudentId() {
        return this.studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Mutator (i.e., setter) for each instance variable from part B1
     */

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }


    /**
     * print() to print specific student data (e.g., student ID, first name, last name)
     * using accessors (i.e., getters)
     */

    public void print() {

        String studentGrades = Arrays.toString(this.getGrades());
        String studentInfo = Integer.toString(this.getStudentId())
                + "\t First Name: " + this.getFirstName()
                + "\t Last Name:  " + this.getLastName()
                + "\t Age: " + this.getAge()
                + "\t Grade: " + studentGrades;

        // print grade
        System.out.println(studentInfo);
    }

} // end class