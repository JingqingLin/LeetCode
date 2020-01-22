import java.util.HashMap;

public class Solution {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();
        ListNode temp = head;
        int i = 1;
        while (temp != null) {
            nodeHashMap.put(i, temp);
            i++;
            temp = temp.next;
        }
//        System.out.printf("长度为%d\n", i - 1);
        // 若为第一个节点
        if (n == i - 1) {
            head = head.next;
        }
        else {
            nodeHashMap.get(i - 1 - n).next = nodeHashMap.get(i + 1 - n);
        }
        return head;
    }
    public static void main(String []args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        ListNode lSum = removeNthFromEnd(l1, 1);
        while (lSum != null) {
            System.out.println(lSum.val);
            lSum = lSum.next;
        }
    }
}
