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
            System.out.println("Insert: " + key + " : " + this.root.person.toString());
            mySize++;
        } else {
            insertNode(key, thePerson, this.root);
        }

    }


    /**
     * Insert node into the tree.
     *
     * @param person
     * @param subTree
     */

    public void insertNode(int key, Person person, TreeNode subTree) {

        if (subTree == null) {
            subTree.hash = key;
            subTree.person = person;
            mySize++;


        } else {

            if (key < subTree.hash) {
                if (subTree.left == null) {
                    subTree.left = new TreeNode(key, person);
                    mySize++;
                    System.out.println("Insert: " + key + " : " + person.toString());
                } else {
                    insertNode(key, person, subTree.left);
                }

            } else if (key > subTree.hash) {
                if (subTree.right == null) {
                    subTree.right = new TreeNode(key, person);
                    mySize++;
                    System.out.println("Insert: " + key + " : " + person.toString());
                } else {
                    insertNode(key, person, subTree.right);
                }
            }
        }
    }

    public void delete(String firstName, String lastName) {
        //
    }


    /**
     * pre-order – process the current node and then traverse the left and right sub-trees.
     *
     * @param firstName
     * @param lastName
     */

    public void lookup(String firstName, String lastName) {
        //

    }

    public int getIndex(String firstName, String lastName) {
        return firstName.concat(lastName).hashCode() & 0x7fffffff;
    }

    public void outputStack() {

        System.out.println("\n --- Debug Tree Information --- \n");
        System.out.println("Size: " + this.getSize() + " \n");

        // traverse output
        this.root.dump();

    }


}
