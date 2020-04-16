import java.util.ArrayList;
import java.util.Collections;

public class BruteForce {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 所有结点存到链表
        ArrayList<Integer> allNodes = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                allNodes.add(list.val);
                list = list.next;
            }
        }
        // 排序
        Collections.sort(allNodes);
        ListNode pre = null, retNode = null;
        ListNode current;
        // 重构链表
        for (int i = 0; i < allNodes.size(); i++) {
            current = new ListNode(allNodes.get(i));
            if (i == 0) {
                retNode = current;
            } else {
                pre.next = current;
            }
            pre = current;
        }
        return retNode;
    }

    public static void main(String[] args) {

    }
}
