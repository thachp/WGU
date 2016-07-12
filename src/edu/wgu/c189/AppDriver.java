package edu.wgu.c189;

import java.util.*;

/**
 * Created by thachp on 2/27/16.
 */

public class AppDriver {

    public static void main(String[] args)
    {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter your test scenario...");
        System.out.println("\t 1 to run Hashtable Test.");
        System.out.println("\t 2 to run BinaryTree Test.");
        System.out.println("\t 3 to run BOTH Tests.");


        try {
            int select = reader.nextInt();
            if(select == 1) {
                hashPeopleTest();
            } else if(select == 2) {
                treePeopleTest();
            }
            else if(select == 3) {
                hashPeopleTest();
                System.out.println("\n \n \t \t \t ######################## \t \t \t");
                treePeopleTest();
            }

        } catch (InputMismatchException e) {
            System.out.println("Enter 1 = Hashtable or 1 = BinaryTree to run check.");
            reader.nextLine();
        }





    }

    /**
     * Test Hash People
     */
    public static void hashPeopleTest() {

        System.out.println("\n >> Test HashTable People \n");

        // use max size of prime number 13, because assign require implementation of 13 buckets.
        HashTable people = new HashTable(13);

        people.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
        people.insert("Jane", "Smith", "555-235-1112", "jw@something.com");
        people.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
        people.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
        people.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
        people.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
        people.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
        people.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        people.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        people.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

        System.out.println("\nSize: " + people.getSize());

        people.lookup("Jane", "Doe");
        people.lookup("Billy", "Kidd");

        System.out.println("");
        people.delete("John", "Doe");
        System.out.println("\nSize: " + people.getSize());


        people.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
        people.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        people.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
        people.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        people.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        people.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
        System.out.println("\nSize: " + people.getSize());

        people.lookup("Jack", "Jones");

        System.out.println("");
        people.delete("Jill", "Jones");
        people.delete("John", "Doe");
        System.out.println("\nSize: " + people.getSize());

        // should return  errors, because it does not exist
        people.lookup("Jill", "Jones");
        people.lookup("John", "Doe");

        // print stack
        people.outputStack();

    }

    /**
     * Test BinaryTree People
     */
    public static void treePeopleTest() {
        System.out.println("\n >> Test BinaryTree People \n");

        BinaryTree people = new BinaryTree();

        people.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
        people.insert("Jane", "Smith", "555-235-1112", "jw@something.com");
        people.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
        people.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
        people.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
        people.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
        people.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
        people.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        people.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        people.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

        System.out.println("\nSize: " + people.getSize());

        people.lookup("Jane", "Doe");
        people.lookup("Billy", "Kidd");

        System.out.println("");
        people.delete("John", "Doe");
        System.out.println("\nSize: " + people.getSize());


        people.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
        people.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        people.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
        people.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        people.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        people.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
        System.out.println("\nSize: " + people.getSize());

        people.lookup("Jack", "Jones");
        people.lookup("Nadezhda", "Kanachekhovskaya");

        System.out.println("");
        people.delete("Jill", "Jones");
        people.delete("John", "Doe");
        System.out.println("\nSize: " + people.getSize());

        // should return  errors, because it does not exist
        people.lookup("Jill", "Jones");
        people.lookup("John", "Doe");

        // print stack
        people.outputStack();

    }

}
