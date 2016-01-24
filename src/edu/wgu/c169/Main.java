package edu.wgu.c169;

/**
 * Program Driver for Roster and Student class
 * Created by pthach2 on 1/23/16.
 */

public class Main {

    public static void main(String[] args) {

        Roster.setStudents();
        Roster.print_all();
        System.out.println("-----");
        Roster.print_invalid_emails();
        System.out.println("-----");

        //loop through the ArrayList and for each student print
        for (Student stud : Roster.myStudents) {

            // note,  O^2 time complexity, because my print_average_grade has O(n)
            // caste to string
            Roster.print_average_grade(""+stud.getStudentId());
        }

        Roster.remove("3");
        System.out.println("-----");
        Roster.remove("3");
    }

} // end main
