import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null, temp;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        int[] arr = new int[cnt];
        int i = 0;
        while (pre != null) {
            arr[i++] = pre.val;
            pre = pre.next;
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(reversePrint(head)[2]);
    }
}
