public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }

        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode newHead = new ListNode(0);
        int count = 0;

        while (++count <= k) {
            fast = fast.next;
            if (fast == null) {
                return head;
            }
        }

        newHead.next = fast;
        count = 0;
        ListNode pre = null, groupTail = null, nextGroupHead = null;


        while (++count <= k) {
            if (count == 1) {
                groupTail = head;
                nextGroupHead = fast.next;
            }

            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
            fast = fast != null ? fast.next : fast;

            if (count == k) {
                count = 0;
                if (fast == null) {
                    groupTail.next = nextGroupHead;
                    break;
                } else {
                    nextGroupHead = fast;
                    groupTail.next = nextGroupHead;
                }
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode newHead;
        newHead = reverseKGroup(head, 4);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
