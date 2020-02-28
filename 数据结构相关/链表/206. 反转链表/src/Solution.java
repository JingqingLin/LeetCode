public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode reverse = new ListNode(-1);

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = reverse;
        recursion(head);
        return newHead.next;
    }

    private static void recursion(ListNode head) {
        if (head == null) {
            return;
        }
        recursion(head.next);
        reverse.next = new ListNode(head.val);
        reverse = reverse.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newHead;
        newHead = reverseList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
