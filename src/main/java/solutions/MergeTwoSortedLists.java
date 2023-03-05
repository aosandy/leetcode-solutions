package solutions;

/**
 * 21. Merge Two Sorted Lists
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(1), null).val);
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode current = prehead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}
