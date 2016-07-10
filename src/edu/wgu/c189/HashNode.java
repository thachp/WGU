package edu.wgu.c189;

/**
 * Created by thachp on 7/10/16.
 */
public class HashNode {


    final int myHash;
    Person person = null;

    // linked-list
    HashNode next = null;

    /**
     *
     * @param theHash
     * @param person
     */
    public HashNode(int theHash, Person person) {

        this.myHash = theHash;
        this.person = person;
    }

}
