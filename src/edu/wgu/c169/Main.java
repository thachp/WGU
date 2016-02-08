package edu.wgu.c169;

/**
 * Program Driver for Roster and Student class
 * Created by pthach2 on 1/23/16.
 */

public class Main {

    public static void main(String[] args) {

        String [] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59",
                "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
                "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
                "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
                "5,Patrick,Thach,pthach2@wgu.edu,30,56,72,95"};

        Roster.setStudents(students);
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


