package leetcode.binarytree.binarytreezigzag;
import java.util.*;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        /*
                3
               / \
              9  20
                 / \
                15  7
         */

        System.out.println("Test 1:");
        System.out.println(zigzagLevelOrder(root1)); // Deve retornar [[3], [20, 9], [15, 7]]

        TreeNode root2 = new TreeNode(1);

        /*
                1
         */

        System.out.println("Test 2:");
        System.out.println(zigzagLevelOrder(root2));

        TreeNode root3 = null;

        System.out.println(zigzagLevelOrder(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        root4.left.left.left = new TreeNode(8);
        root4.left.left.right = new TreeNode(9);

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
              / \
             8   9
         */

        System.out.println(zigzagLevelOrder(root4));
    }

}
