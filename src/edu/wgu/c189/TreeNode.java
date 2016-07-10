package edu.wgu.c189;

/**
 * Created by thachp on 7/10/16.
 */
public class TreeNode {

    public int hash;
    Person person;
    TreeNode left = null;
    TreeNode right = null;


    public TreeNode(int hash, Person person) {
        this.hash = hash;
        this.person = person;
    }

    // perform an in-order traversal of the current node
    public void dump() {
        if (this.left != null) {
            this.left.dump();
        }

        System.out.println("Traverse: " + this.person.toString());

        if (this.right != null) {
            this.right.dump();
        }
    }


}
