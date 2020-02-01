import java.util.List;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head == null ? null : head.next;
        if (slow == null || fast == null) {
            return false;
        }
        while (slow != null) {
            if (slow == fast) {
                return true;
            }
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = null;
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = head;
        System.out.println(hasCycle(head));
    }
}
