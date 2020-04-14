import java.util.LinkedList;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.addLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode pre;
        ListNode current = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pollLast().val;
            sum += stack2.isEmpty() ? 0 : stack2.pollLast().val;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            pre = current;
            current = new ListNode(sum);
            current.next = pre;
        }
        return current;
    }

    public static void main(String[] args) {

    }
}
