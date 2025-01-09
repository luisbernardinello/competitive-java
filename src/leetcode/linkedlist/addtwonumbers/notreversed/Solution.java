package leetcode.linkedlist.addtwonumbers.notreversed;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

////https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/
public class Solution {

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static Node addTwoNumbers(Node num1, Node num2) {

        num1 = reverse(num1);
        num2 = reverse(num2);

        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (num1 != null || num2 != null || carry > 0) {
            int sum = carry;

            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;

        }
        return reverse(dummyHead.next);
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(0);

        Node head2 = new Node(2);
        head2.next = new Node(0);
        head2.next.next = new Node(0);

        Node result = addTwoNumbers(head1, head2);

        printList(result);

    }
}
