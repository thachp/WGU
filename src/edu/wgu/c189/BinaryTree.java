package edu.wgu.c189;


/**
 * A data structure in which a record is linked to two successor records,
 * usually referred to as the left branch when greater and the right when less than the previous record.
 *
 * PT
 * @author pthach2@wgu.edu
 */

public class BinaryTree {


    protected TreeNode root; // the root node of our tree
    protected int mySize = 0;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Is the tree empty?
     * PT
     * @return
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * How many nodes are there in this tree?
     *
     * PT
     * @return
     */
    public int getSize() {
        return mySize;
    }

    /**
     * Create new person object and insert into binary tree.
     * The TreeNode has unique hashcode assigned. Node having less hashcode (int) than parent
     * will be assigned to the left, vice versa greater will be assigned to the right branch.
     *
     * Time complexity: O(log(n), worst: O(n)
     *
     * PT
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */
    public void insert(String firstName, String lastName,
                       String emailAddress, String phoneNumber) {

        Person thePerson = new Person(firstName, lastName, emailAddress, phoneNumber);
        int key = getHash(firstName, lastName);

        if (this.isEmpty()) {
            this.root = new TreeNode(key, thePerson);
            System.out.println("Insert Root: " + key + " : " + this.root.person.toString());
        } else {
            this.root.insert(key, thePerson, this.root);
        }

        mySize++;
    }

    /**
     * Similar to insert, this recursive method delete node from subtree by hash.
     * Time complexity: O(log(n), worst: O(n)
     *
     * PT
     * @param firstName
     * @param lastName
     */
    public void delete(String firstName, String lastName) {
        int key = getHash(firstName, lastName);
        // delete key, traverse from root
        boolean isDeleted = this.root.delete(key, null);

        if (isDeleted) {
            mySize--;
            System.out.println("Delete: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " deleted.");
        }

    }

    /**
     * Recursively find a children of this node by key.
     *
     * Traverse Pre-Order
     * Display the data part of the root (or current node).
     * Traverse the left subtree by recursively calling the pre-order function.
     * Traverse the right subtree by recursively calling the pre-order function.
     *
     * Time Complexity: O(log(n)), worst: O(n)
     * PT
     * @param firstName
     * @param lastName
     */

    public void lookup(String firstName, String lastName) {

        int key = getHash(firstName, lastName);
        TreeNode node =  this.root.find(key);

        if(node != null) {
            System.out.println("Lookup: " + node.person.toString());
        } else {
            System.out.println("Lookup: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        }

    }

    /**
     * Generate hashCode base on firstname and lastname.
     * This hashcode will be used to identify node when doing lookup.
     *
     * @TODO Hashcode() do not gauranteed unique ID, this can be enhanced later.
     *
     * PT
     * @param firstName
     * @param lastName
     * @return
     */
    public int getHash(String firstName, String lastName) {
        return firstName.concat(lastName).hashCode();
    }


    /**
     * Not in requirement, but helpful when debugging
     * Time Complexity: 0(n), because it has to traverse all nodes.
     * PT
     */
    public void outputStack() {

        System.out.println("\n --- Debug Tree Information --- \n");
        System.out.println("Size Count: " + this.getSize() + " \n");

        // traverse output
        this.root.dump();

    }


}
