package solutions;

import java.util.HashMap;

/**
 * 206. Reverse Linked List
 */

public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println(reverseList(new ListNode()));
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
