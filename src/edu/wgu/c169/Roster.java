package edu.wgu.c169;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pthach2 on 1/23/16.
 */

public class Roster {

    // hold student rosters
    static ArrayList<Student> myStudents = new ArrayList<>();
    static ArrayList<String> myBadEmails = new ArrayList<>();

    /**
     * Set students
     * @param students
     */
    public static void setStudents(String[] students) {

        for (String student : students) {
            String[] profile = student.split(",");
            add(profile[0], profile[1], profile[2], profile[3],
                    Integer.parseInt(profile[4]),
                    Integer.parseInt(profile[5]),
                    Integer.parseInt(profile[6]),
                    Integer.parseInt(profile[7])
            );
        }
    }

    /**
     * Add student to my students roster.
     * @param studentID
     * @param firstname
     * @param lastname
     * @param emailaddress
     * @param age
     * @param grade1
     * @param grade2
     * @param grade3
     */
    public static void add(String studentID, String firstname, String lastname, String emailaddress,
                           int age, int grade1, int grade2, int grade3) {


        Student stud = new Student();
        stud.setStudentId(Integer.parseInt(studentID));
        stud.setFirstName(firstname);
        stud.setLastName(lastname);
        stud.setEmail(emailaddress);
        stud.setAge(age);
        stud.setGrades(new int[]{grade1, grade2, grade3});

        Roster.myStudents.add(stud);

    }

    /**
     * Remove from studentID from arraylist
     *
     * @param studentID
     */
    public static void remove(String studentID) {
        Student isFound = Roster.findStudent(studentID);
        if (isFound == null) {
            System.out.println("Student ID " + studentID + " not found.");
        }

        // remove from lsit
        myStudents.remove(isFound);
    }

    /**
     * Print a complete tab-separated list of student data using accessor methods
     */
    public static void print_all() {
        Iterator<Student> s = myStudents.iterator();
        while (s.hasNext()) {
            s.next().print();
        }
    }

    /**
     * Print average grade for a student
     *
     * @param studentID
     */
    public static void print_average_grade(String studentID) {

        Student theStudent = Roster.findStudent(studentID);
        int theTotal = 0;

        if (theStudent == null) {
            System.out.println("Student ID" + studentID + " not found.");
        }
        for (int grade : theStudent.getGrades()) {
            theTotal += grade;
        }

        // print average grade
        System.out.println("Student Id: " + studentID + " \t Average: " + (theTotal / theStudent.getGrades().length));
    }

    /**
     * Verifies student e-mail addresses and displays all invalid e-mail addresses to the user
     */

    public static void print_invalid_emails() {

        // FailedDev. (2011, November 20). Java regex email [Msg 8204703].
        // Message posted to http://stackoverflow.com/questions/8204680/java-regex-email
        Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");

        // loop through each email if bad add to add email arraylist
        for (Student stud : myStudents) {
            Matcher matcher = pattern.matcher(stud.getEmail());
            if (matcher.matches() == false) {
                myBadEmails.add(stud.getEmail());
            }
        }

        // build invalid
        StringBuilder sb = new StringBuilder();

        for (String s : myBadEmails) {
            sb.append(",");
            sb.append(s);
        }

        // remove first comma
        sb.deleteCharAt(0);

        if (myBadEmails.size() > 0) {
            System.out.println("Bad emails: " + sb.toString());
        } else {
            System.out.println("No bad emails found.");
        }
    }

    /**
     * Helper: Find student by student ID
     *
     * @param studentID
     * @return
     */
    private static Student findStudent(String studentID) {
        for (Student stud : myStudents) {
            if (stud.getStudentId() == Integer.parseInt(studentID)) {
                return stud;
            }
        }
        return null;
    }

} // end Roster
