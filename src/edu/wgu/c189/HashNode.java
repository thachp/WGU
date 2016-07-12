package edu.wgu.c189;

/**
 * Created by thachp on 7/10/16.
 */
public class HashNode {


    int hash;
    Person person = null;

    // signly linkedlist
    HashNode next;

    /**
     * @param hash
     * @param person
     */
    public HashNode(int hash, Person person) {
        this.hash = hash;
        this.person = person;
    }


    /**
     *
     * @return
     */

    public HashNode removeAt(String fullName) {

        // if fullname exist in head node
        if (person.myFullName.equals(fullName)) {
            if (next == null) {
                return null;
            }

            return next;
        }

        HashNode prev = this;
        while (prev.next != null && !prev.next.person.myFullName.equals(fullName)) {
            prev = prev.next;
        }

        if (prev.next == null) {
            return null;
        }

        prev.next = prev.next.next;

        // return head
        return this;

    }

}
