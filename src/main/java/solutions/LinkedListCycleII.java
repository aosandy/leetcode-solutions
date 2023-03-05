package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 */

public class LinkedListCycleII {
    public static void main(String[] args) {
        System.out.println(detectCycle_1(new ListNode(1)));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // O(n) memory
    public static ListNode detectCycle_1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null && !visited.contains(head)) {
            visited.add(head);
            head = head.next;
        }
       return head;
    }

    // O(1) memory
    public static ListNode detectCycle_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
