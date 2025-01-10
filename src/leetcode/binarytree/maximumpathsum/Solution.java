package leetcode.binarytree.maximumpathsum;
import java.util.*;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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

    public static int maxPathSum(TreeNode root) {
        int[] ans = new int[] { Integer.MIN_VALUE };
        findMaxPathSum(root, ans);
        return ans[0];
    }

    private static int findMaxPathSum(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, findMaxPathSum(node.left, ans));
        int right = Math.max(0, findMaxPathSum(node.right, ans));

        int pathSum = left + right + node.val;

        ans[0] = Math.max(ans[0], pathSum);

        return Math.max(left, right) + node.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*
                -10
                /  \
               9   20
                  /  \
                 15   7
        */

        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }

}
