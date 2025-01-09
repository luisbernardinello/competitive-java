package leetcode.binarytree.binarytreetocirculardll;

//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    private Node prev = null;
    private Node head = null;

    public Node bToDLL(Node root) {
        if (root == null) return null;

        inorder(root);

        // convert into a circular double linked list
        if (head != null && prev != null) {
            prev.right = head; // Last node points to the first
            head.left = prev;  // First node points to the last
        }

        return head;
    }

    private void inorder(Node root) {
        // base
        if (root == null) return;

        inorder(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        inorder(root.right);
    }

    public void printList(Node head) {
        if (head == null) return;

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.right;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        /*
              10
             /  \
           12    15
          /  \   /
         25  30 36
        */

        Solution solution = new Solution();
        Node dll = solution.bToDLL(root);

        System.out.println("Doubly Linked List (Circular):");
        solution.printList(dll);
    }
}

