package solutions;

/**
 * 21. Merge Two Sorted Lists
 */

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        System.out.println(middleNode(new ListNode(1)));
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode middleNode(ListNode head) {
        ListNode iterNode = head;
        ListNode middleNode = head;
        int i = 0;
        int mid = 0;
        while (iterNode != null) {
            i++;
            iterNode = iterNode.next;
            if (i / 2 > mid) {
                mid++;
                middleNode = middleNode.next;
            }
        }
        return middleNode;
    }
}
