package leetcode.binarytree.diameter;
import java.util.*;
//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
//https://leetcode.com/problems/diameter-of-binary-tree/description/
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class Solution {

    static int diameter(Node root) {
        int[] result = new int[1];
        diameterRecursive(root, result);
        return result[0];
    }

    // Recursive function which finds the
    // height of root and also calculates
    // the diameter of the tree.
    static int diameterRecursive(Node root, int[] result) {
        // Base case: tree is empty
        if (root == null) {
            return 0;
        }

        // find the height of left and right subtree
        // (it will also find of diameter for left
        // and right subtree).
        int leftHeight = diameterRecursive(root.left, result);
        int rightHeight = diameterRecursive(root.right, result);


        // Check if diameter of root is greater
        // than res.
        result[0] = Math.max(result[0], leftHeight + rightHeight);

        // return the height of current subtree.
        return 1 + Math.max(leftHeight, rightHeight);


    }


    public static void main(String[] args) {

        // Constructed binary tree is
        //          5
        //        /   \
        //       8     6
        //      / \   /
        //     3   7 9
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);

        System.out.println(diameter(root));
    }

}
