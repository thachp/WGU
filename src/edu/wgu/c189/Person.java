package edu.wgu.c189;

/**
 * This class generate person entry tobe used in Hashtable and BinaryTree data structure.
 * Created by thachp on 7/10/16.
 */
public class Person {

    // Person attributes
    String myFullName;
    String myEmailAddress;
    String myPhoneNUmber;

    /**
     * Create new person entry
     *
     * @param
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */
    public Person(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.myFullName = firstName.toUpperCase() + " " + lastName.toUpperCase();
        this.myEmailAddress = emailAddress;
        this.myPhoneNUmber = phoneNumber;
    }

    /**
     * Override default toString()s
     * @return
     */
    public String toString() {
        return myFullName + " " + myPhoneNUmber + " " + myEmailAddress;
    }

} // end class
