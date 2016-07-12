package edu.wgu.c189;

/**
 * A Hashtable is a data strucuture that is similar to associate array, it maps key to value.
 * @author pthach2@wgu.edu
 */

public class HashTable {

    private int MY_MAX_SIZE;
    private int mySize;
    private HashNode[] myNodes;

    /**
     * Constructor
     * PT: Not sure if Arraylist is allowed in this task, so will not use arraylist.
     * Instead will use java array that will hold fix number of Hashnode type.
     * @param maxSize
     */

    public HashTable(int maxSize) {

        this.mySize = 0;

        if (maxSize <= 0) {
            throw new IllegalArgumentException("Illegal max size");
        }

        this.MY_MAX_SIZE = maxSize;

        // allocate memory to maxSize
        myNodes = new HashNode[maxSize];

    }

    /**
     * How items do I have in this table?
     * PT
     * @return
     */
    public int getSize() {
        return mySize;
    }

    /**
     * PT
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

        // PT if my person have not exist, add it to hash key
        if (myNodes[theKey] == null) {
            myNodes[theKey] = new HashNode(theKey, thePerson);
            System.out.println("Insert: Bucket " + theKey + " : " +  myNodes[theKey].person.toString());
        } else {

            // has already exist, so we chain it.
            HashNode headNode =  new HashNode(theKey, thePerson);
            headNode.next = myNodes[theKey];
            myNodes[theKey]  = headNode;

            System.out.println("Insert Chain: Bucket " +theKey + " : " + myNodes[theKey].person.toString());

        }

        mySize++;

    }

    /**
     * Delete person from my people by first and last name.
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     * PT
     * @param firstName
     * @param lastName
     */
    public void delete(String firstName, String lastName) {

        int theKey = getHashIndex(firstName, lastName);

        if (myNodes[theKey] == null) {
            System.out.println("Delete: Bucket : " + theKey + " : " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        }

        if (myNodes[theKey] != null) {

            // PT Loop through everyone in hash chain, reduce count by 1
            // O(n) time complexity occur in the removeAt() method of HashNode.
            String fullName = firstName.toUpperCase() + " " + lastName.toUpperCase();
            myNodes[theKey] = myNodes[theKey].removeAt(fullName);

            System.out.println("Delete: Bucket : " + theKey + " : " + firstName.toUpperCase() + " " + lastName.toUpperCase() + ".");
            mySize--;
        }

    }

    /**
     * Return person having first and last name
     * Time Complexity: o(1), worst at o(n) -> because of chain to avoid hash collision.
     * PT
     * @param firstName
     * @param lastName
     * @return
     */
    public HashNode lookup(String firstName, String lastName) {
        int theKey = getHashIndex(firstName, lastName);

        if (myNodes[theKey] == null) {
            System.out.println("Lookup: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        } else {
            Person person = myNodes[theKey].person;
             System.out.println("Lookup: Bucket " +  theKey +" : "+ person.toString());
        }

        return myNodes[theKey];
    }


    /**
     * Generate hashkey by combining first name and last name string.
     * This ensure that all hashcodes are between o and the max_size
     * To avoid collision, I will support chaining of Person object in the insert statement
     * PT
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
     * Though, not in the requirement, I use this could to print all node in the data structures.
     * It helps visually see # of elements currently in the table. This should not be invoked if table get too big.
     * PT
     * @return
     */

    public void outputStack() {

        System.out.println("\n --- Debug Hash Information --- \n");
        System.out.println("Size: " +  this.getSize() + " \n");

        for(HashNode node: myNodes) {
            if(node != null) {
                System.out.print("Bucket Index: " + node.hash + " : ");
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
