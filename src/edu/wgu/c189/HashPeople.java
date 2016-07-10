package edu.wgu.c189;

/**
 * A Hashtable is a data strucuture that is similar to associate array in PHP, it maps
 * key to value.
 *
 * Created by thachp on 7/10/16.
 */
public class HashPeople {

    // should be a prime number
    private int MY_MAX_SIZE;
    private int mySize;
    private Person[] myPeople;

    /**
     * Constructor
     * @param maxSize
     */
    public HashPeople(int maxSize)
    {
        // start with 0 size
        this.mySize = 0;

        // Not sure if Arraylist is allowed in this task, so will not use arraylist.
        // Instead will use java array that will hold fix number of Person type.
        this.MY_MAX_SIZE = maxSize;
    }

    /**
     * Insert person object to myPeople
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */

    public void insert(String firstName, String lastName,
                       String emailAddress, String phoneNumber) {

        int theKey = getHashIndex(firstName, lastName);
        Person thePerson = new Person( theKey,firstName, lastName, emailAddress, phoneNumber);

        // if my person have not exist, add it to hash key
        if (myPeople[theKey] == null)
        {
            myPeople[theKey] = thePerson;
        }  {
            // has already exist, so we will chain to the tail node.
            // loop till end of chain, next is end of chain if it is null
            Person currentPerson = myPeople[theKey];

            // only link if object not equal other person in chain.
            while (currentPerson.next != null && !currentPerson.next.equals(currentPerson)) {
                currentPerson.next = thePerson;
            }

        }

        // increase size by one
        mySize++;

    }

    /**
     * Delete person from my people by first and last name.
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     * @param firstName
     * @param lastName
     */
    public void delete(String firstName, String lastName) {
        int theKey = getHashIndex(firstName, lastName);

        if (myPeople[theKey] != null)
        {
            // loop through everyone in hash chain, reduce count by 1
            Person currentPerson = myPeople[theKey];

            while (currentPerson.next != null) {
                currentPerson = currentPerson.next;
                this.mySize--;
            }

            // set hashKey to null, therefore removing the element from the array
            myPeople[theKey] = null;

        }

    }

    /**
     * Return person having first and last name
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     * @param firstName
     * @param lastName
     * @return
     */
    public Person lookup(String firstName, String lastName) {
        int theKey = getHashIndex(firstName, lastName);
        return myPeople[theKey];
    }

    /**
     * Generate hashkey by combining first name and last name string.
     * This is by no-way a perfect algorithm because it assume first and last name will always be unique.
     * To avoid collision, I will support chaining of Person object in the insert statement
     * @param firstName
     * @param lastName
     * @return
     */
    private int getHashIndex(String firstName, String lastName) {
        return firstName.hashCode() + lastName.hashCode();
    }



}
