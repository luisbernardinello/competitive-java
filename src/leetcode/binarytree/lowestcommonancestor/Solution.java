package leetcode.binarytree.lowestcommonancestor;
import java.util.*;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);

        /*
                3
               / \
              5   1
             / \  / \
            6  2 0   8
              / \
             7   4
        */

        TreeNode p1 = root1.left;
        TreeNode q1 = root1.left.right.right;

        TreeNode lca1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("LCA: " + p1.val + " and " + q1.val + ": " + (lca1 != null ? lca1.val : "null"));

    }

}
