package edu.wgu.c189;

import java.util.Objects;

/**
 * A Hashtable is a data strucuture that is similar to associate array in PHP, it maps
 * key to value.
 * <p>
 * Created by thachp on 7/10/16.
 */
public class HashTable {

    // should be a prime number
    private int MY_MAX_SIZE;
    private int mySize;
    private HashNode[] myNodes;

    /**
     * Constructor
     *
     * @param maxSize
     */
    public HashTable(int maxSize) {

        // start with 0 size
        this.mySize = 0;

        // throw error if maxSize is less or equal to 0
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Illegal max size");
        }

        // Not sure if Arraylist is allowed in this task, so will not use arraylist.
        // Instead will use java array that will hold fix number of Person type.
        this.MY_MAX_SIZE = maxSize;

        // allocate memory to maxSize
        myNodes = new HashNode[maxSize];

    }


    /**
     * How items do I have in this table?
     *
     * @return
     */
    public int getSize() {
        return mySize;
    }

    /**
     * Insert person object to myPeople
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     *
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */

    public void insert(String firstName, String lastName,
                       String emailAddress, String phoneNumber) {

        int theKey = getHashIndex(firstName, lastName);
        Person thePerson = new Person(firstName, lastName, emailAddress, phoneNumber);

        // if my person have not exist, add it to hash key
        if (myNodes[theKey] == null) {
            myNodes[theKey] = new HashNode(theKey, thePerson);
            System.out.println("Insert: Bucket " + theKey + " : " +  myNodes[theKey].person.toString());
        } else {

            // has already exist, so we chain it.
            HashNode previousNode = myNodes[theKey];

            myNodes[theKey] = new HashNode(theKey, thePerson);
            myNodes[theKey].next = previousNode;

            System.out.println("Insert Chain: Bucket " +theKey + " : " + myNodes[theKey].person.toString());

        }

        // increase size by one
        mySize++;

    }

    /**
     * Delete person from my people by first and last name.
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     *
     * @param firstName
     * @param lastName
     */
    public void delete(String firstName, String lastName) {

        int theKey = getHashIndex(firstName, lastName);

        if (myNodes[theKey] == null) {
            System.out.println("Delete: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        }

        if (myNodes[theKey] != null) {

            // loop through everyone in hash chain, reduce count by 1
            HashNode currentNode = myNodes[theKey];

            if (currentNode.next != null) {
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    mySize--;
                }
            }

            System.out.println("Delete: " + currentNode.person.toString());
            mySize--;


            // set hashKey to null, therefore removing the element from the array
            myNodes[theKey] = null;

        }

    }

    /**
     * Return person having first and last name
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     *
     * @param firstName
     * @param lastName
     * @return
     */
    public void lookup(String firstName, String lastName) {
        int theKey = getHashIndex(firstName, lastName);

        if (myNodes[theKey] == null) {
            System.out.println("Lookup: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        } else {
            Person person = myNodes[theKey].person;
            System.out.println("Lookup: Bucket " +  theKey +" : "+ person.toString());
        }
    }


    /**
     * Generate hashkey by combining first name and last name string.
     * This ensure that all hashcodes are between o and the max_size
     * To avoid collision, I will support chaining of Person object in the insert statement
     *
     * @param firstName
     * @param lastName
     * @return
     */
    private int getHashIndex(String firstName, String lastName) {

        String key = firstName.concat(lastName);

        int hashIndex = key.hashCode() % MY_MAX_SIZE;

        if (hashIndex < 0) {
            hashIndex = hashIndex + MY_MAX_SIZE;
        }

        return hashIndex;
    }


    /**
     * Though, not in the requirement to print all node in the data structures.
     * @return
     */

    public void outputStack() {

        System.out.println("\n --- Debug Hash Information --- \n");
        System.out.println("Size: " +  this.getSize() + " \n");

        for(HashNode node: myNodes) {
            if(node != null) {
                System.out.print("Bucket Index: " + node.myHash + " : ");
                HashNode current = node;

                while(current != null) {
                    System.out.print(current.person.toString() );
                    if(current.next != null) {
                        System.out.print(" : ");
                    }
                    current = current.next;
                }

                System.out.print("\n");
            }
        }
    }



}
