import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        ListNode res = middleNode(head);
        System.out.println(res.val);
    }
}
