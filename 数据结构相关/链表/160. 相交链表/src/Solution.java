import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 哈希表
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> headSet = new HashSet<>();
        while (headA != null) {
            headSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (headSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
