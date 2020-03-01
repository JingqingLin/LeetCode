// https://leetcode-cn.com/problems/add-two-numbers/

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            assert l1 != null;
            l3.val = l1.val + l2.val + carry;
            if (l3.val >= 10) {
                carry = 1;
                l3.val -= 10;
            } else {
                carry = 0;
            }
            if (l1.next != null && l2.next != null) {
                l3.next = new ListNode(0);
                l1 = l1.next;
                l2 = l2.next;
                l3 = l3.next;
            } else if (l1.next != null) {
                l3.next = new ListNode(0);
                l1 = l1.next;
                l2.val = 0;
                l3 = l3.next;
            } else if (l2.next != null) {
                l3.next = new ListNode(0);
                l2 = l2.next;
                l1.val = 0;
                l3 = l3.next;
            } else {
                // 最高位进位
                if (carry == 1) {
                    l3.next = new ListNode(1);
                }
                break;
            }
        }
        return l4;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(0);
        ListNode l2 = new ListNode(8);
//        l2.next = new ListNode(6);
//       l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(4);
        ListNode lSum = addTwoNumbers(l1, l2);
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
