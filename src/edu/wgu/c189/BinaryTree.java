package edu.wgu.c189;

/**
 * Created by thachp on 7/10/16.
 */
public class BinaryTree {


    protected TreeNode root; // the root node of our tree
    protected int mySize = 0;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }


    public int getSize() {
        return mySize;
    }

    /**
     * PT: AS
     *
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber
     */
    public void insert(String firstName, String lastName,
                       String emailAddress, String phoneNumber) {

        Person thePerson = new Person(firstName, lastName, emailAddress, phoneNumber);
        int key = getIndex(firstName, lastName);

        // recursive
        if (this.isEmpty()) {
            this.root = new TreeNode(key, thePerson);
            System.out.println("Insert Root: " + key + " : " + this.root.person.toString());
        } else {
            this.root.insert(key, thePerson, this.root);
        }

        mySize++;
    }

    /**
     * Delete
     *
     * @param firstName
     * @param lastName
     */
    public void delete(String firstName, String lastName) {
        int key = getIndex(firstName, lastName);
        // delete key, traverse from root
        boolean isDeleted = this.root.delete(key, null);

        if (isDeleted == true) {
            mySize--;
            System.out.println("Delete: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " deleted.");
        }

    }

    /**
     * pre-order – process the current node and then traverse the left and right sub-trees.
     *
     * @param firstName
     * @param lastName
     */

    public void lookup(String firstName, String lastName) {

        int key = getIndex(firstName, lastName);

        TreeNode node =  this.root.find(key);

        if(node != null) {
            System.out.println("Lookup: " + node.person.toString());
        } else {
            System.out.println("Lookup: " + firstName.toUpperCase() + " " + lastName.toUpperCase() + " not found.");
        }

    }

    /**
     * Generate positve key hash
     *
     * @param firstName
     * @param lastName
     * @return
     */
    public int getIndex(String firstName, String lastName) {
        return firstName.concat(lastName).hashCode() & 0x7fffffff;
    }

    /**
     * Output stack
     */
    public void outputStack() {

        System.out.println("\n --- Debug Tree Information --- \n");
        System.out.println("Size: " + this.getSize() + " \n");

        // traverse output
        this.root.dump();

    }


}
