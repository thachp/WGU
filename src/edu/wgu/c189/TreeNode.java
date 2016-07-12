package edu.wgu.c189;

/**
 * Created by thachp on 7/10/16.
 */
public class TreeNode {

    int hash;
    Person person;
    TreeNode left = null;
    TreeNode right = null;


    public TreeNode(int hash, Person person) {
        this.hash = hash;
        this.person = person;
    }


    /**
     *
     * @param key
     * @return
     */
    public TreeNode find(int key) {
        if (key == this.hash)
            return this;

        else if (key < this.hash) {
            if (left == null)
                return null;
            else
                return left.find(key);
        } else if (key > this.hash) {
            if (right == null)
                return null;
            else
                return right.find(key);
        }
        return null;
    }



    public Person findMin() {
        if (left == null)
            return person;
        else
            return left.findMin();
    }

    /**
     * Insert
     *
     * @param key
     * @param person
     * @param parent
     * @return
     */

    public boolean insert(int key, Person person, TreeNode parent) {

        if (this.person == null) {
            this.hash = key;
            this.person = person;
        } else {
            if (key < parent.hash) {
                if (parent.left == null) {
                    left = new TreeNode(key, person);
                    System.out.println("Insert Left: " + key + " : " + person.toString());
                } else {
                    return parent.left.insert(key, person, this);
                }
            }
            if (key > parent.hash) {

                if (parent.right == null) {
                    right = new TreeNode(key, person);
                    System.out.println("Insert Right: " + key + " : " + person.toString());

                } else {
                    return parent.right.insert(key, person, this);
                }
            }
        }
        return true;
    }


    /**
     * Delete this node
     *
     * @param parent
     */
    public boolean delete(int key, TreeNode parent) {
        if (key < hash) {
            if (left != null)
                return left.delete(key, this);
            else
                return false;
        } else if (key > hash) {
            if (right != null)
                return right.delete(key, this);
            else
                return false;

        } else {
            if (left != null && right != null) {
                this.person = right.findMin();
                right.delete(key, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
        }
        return true;
    }


    // perform an in-order traversal of the current node
    public void dump() {
        if (this.left != null) {
            this.left.dump();
        }

        System.out.println("Traverse: " + this.hash + " : " + this.person.toString());

        if (this.right != null) {
            this.right.dump();
        }
    }


}
