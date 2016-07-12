package edu.wgu.c189;

/**
 * This class generate person entry tobe used in Hashtable and BinaryTree data structure.
 * PT
 *
 * @author pthach2@wgu.edu
 */
public class Person {

    String myFullName;
    String myFirstName;
    String myLastName;
    String myEmailAddress;
    String myPhoneNUmber;

    /**
     * Constructor
     * Create new person entry
     * PT
     *
     * @param
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */

    public Person(String firstName, String lastName, String phoneNumber, String emailAddress) {

        this.myFullName = firstName.toUpperCase() + " " + lastName.toUpperCase();
        this.myFirstName = firstName;
        this.myLastName = lastName;
        this.myEmailAddress = emailAddress;
        this.myPhoneNUmber = phoneNumber;
    }

    /**
     * Override default toString()s
     * PT
     * @return
     */
    public String toString() {
        return myFullName + " " + myPhoneNUmber + " " + myEmailAddress;
    }

} // end class
