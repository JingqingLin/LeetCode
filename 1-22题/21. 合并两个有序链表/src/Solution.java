public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        ListNode l3, l4;
        l3 = new ListNode(0);
        l4 = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = new ListNode(l1.val);
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l3 = l3.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return l4.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(0);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);
//        l2.next.next.next = new ListNode(4);
        ListNode lSum = mergeTwoLists(l1, l2);
        while (lSum != null) {
            System.out.println(lSum.val);
            lSum = lSum.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
