package edu.wgu.c189;

/**
 * This class will allow creation of HashNode object.
 * It is hold reference to Person object.
 * PT
 *
 * @author pthach2@wgu.edu
 */

public class HashNode {


    int hash;
    Person person = null;

    // signly linkedlist
    HashNode next;

    /**
     * Constructor
     *
     * @param hash
     * @param person
     */
    public HashNode(int hash, Person person) {
        this.hash = hash;
        this.person = person;
    }

    /**
     * Loop through all node in next matching fullname, rebuild the link-list
     * then returh Head or head.next.
     *
     * Time Complexity: O(n)
     * PT
     *
     * @return
     */

    public HashNode removeAt(String fullName) {

        // if fullname exist in head node and next is null
        // then return next
        // PT returna
        if (person.myFullName.equals(fullName)) {
            if (next == null) {
                return null;
            }

            return next;
        }

        // Continue looping till node containing the fullName exist.
        // PT
        HashNode current = this;
        while (current.next != null && !current.next.person.myFullName.equals(fullName)) {
            current = current.next;
        }

        if (current.next == null) {
            return null;
        }

        current.next = current.next.next;

        // return head
        return this;
    }

}
