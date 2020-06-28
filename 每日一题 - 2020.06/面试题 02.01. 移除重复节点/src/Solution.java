import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> hashset = new HashSet<>();
        hashset.add(head.val);
        ListNode newHead = head;
        ListNode pre = head;
        newHead = newHead.next;

        while (newHead != null) {
            if (!hashset.contains(newHead.val)) {
                hashset.add(newHead.val);
                pre = pre.next;
            } else {
                pre.next = newHead.next;
            }
            newHead = newHead.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
