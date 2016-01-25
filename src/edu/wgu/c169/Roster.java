package edu.wgu.c169;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pt133e on 1/23/16.
 */

public class Roster {

    // hold student rosters
    static ArrayList<Student> myStudents = new ArrayList<>();
    static ArrayList<String> myBadEmails = new ArrayList<>();

    public static void setStudents() {
        myStudents.add(new Student(1, "John", "Smith", "John1989@gmail.com", 20, new int[]{88, 79, 59}));
        myStudents.add(new Student(2, "Suzan", "Erickson", "Erickson_1990@gmailcom", 19, new int[]{91, 72, 85}));
        myStudents.add(new Student(3, "Jack", "Napoli", "the_lawyer99@yahoo.com", 19, new int[]{85, 84, 87}));
        myStudents.add(new Student(4, "Erin", "Black", "Erin.black@comast.net", 19, new int[]{91, 98, 82}));
        myStudents.add(new Student(5, "Patrick", "Thach", "pthach2@wgu.edu", 30, new int[]{56, 72, 95}));
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
        System.out.println("Average: " + (theTotal / theStudent.getGrades().length));
    }

    /**
     * verifies student e-mail addresses and displays all invalid e-mail addresses to the user
     * @credit http://stackoverflow.com/questions/8204680/java-regex-email
     */

    public static void print_invalid_emails() {

        // regex exprssion for email
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
