package edu.wgu.c189;

/**
 * This class will allow creation of TreeNode object.
 * It is hold reference to Person object.
 * PT
 *
 * @author pthach2@wgu.edu
 */
public class TreeNode {

    int hash;
    Person person;
    TreeNode left = null;
    TreeNode right = null;

    /**
     * Constructor
     * Hold reference to Pereson object.
     * Store hash to support BinaryTree.
     * PT
     * @param hash
     * @param person
     */
    public TreeNode(int hash, Person person) {
        this.hash = hash;
        this.person = person;
    }


    /**
     *  Recursively find a children of this node by key.
     *  Time Complexity: O(log(n)), worst: O(n)
     *
     *  PT
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

    /**
     * Find the minimum children of this node.
     * Time complexity: O(log(n), worst: O(n)
     *
     * PT
     * @return
     */
    public Person findMin() {
        if (left == null)
            return person;
        else
            return left.findMin();
    }

    /**
     * Insert node in its rightful place.
     * Inside left if key is less than current node,
     * Inside right if key greater than curret node.
     *
     * Time complexity: O(log(n), worst: O(n)
     * PT
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
     * Similar to insert, this recursive method delete node from subtree by hash.
     * It also rebuild subtree.
     *
     * Time complexity: O(log(n), worst: O(n)
     * PT
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

    /**
     * Though not in requirement, this helped see number of nodes in the tree.
     * PT
     */
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
