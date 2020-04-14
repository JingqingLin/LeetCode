public class DoubleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.prev = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.prev = head;
        head.next.next = new ListNode(3);
        head.next.next.prev = head.next.next;
        ListNode newHead;
        newHead = reverseList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
