package edu.wgu.c189;

/**
 * This class generate person entry tobe used in Hashtable and TreePeople data structure.
 * Created by thachp on 7/10/16.
 */
public class Person {

    // Person attributes
    private int myKey;
    String myFirstName;
    String myLastName;
    String myFullName;
    String myEmailAddress;
    String myPhoneNUmber;

    // Store references used to chain nodes
    // could also be use as left or right
    Person previous = null;
    Person next = null;

    /**
     * Create new person entry
     *
     * @param
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */

    public Person(int theKey, String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.myKey = theKey;
        this.myFirstName = firstName.toUpperCase();
        this.myLastName = lastName.toUpperCase();
        this.myEmailAddress = emailAddress;
        this.myPhoneNUmber = phoneNumber;
        this.myFullName = this.myFirstName + " " + this.myLastName;
    }

    /**
     * Return object hash code
     * @return
     */
    public int getKey() {
        return this.myKey;
    }

} // end class
