public class Compare {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode retList = null;
        ListNode pre = null, current;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            int residueNode = k;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                residueNode--;
                if (min > lists[i].val) {
                    minIndex = i;
                    min = lists[i].val;
                }
            }
            if (residueNode == k) {
                break;
            }
            current = new ListNode(lists[minIndex].val);
            if (retList == null) {
                retList = current;
            } else {
                pre.next = current;
            }
            pre = current;
            lists[minIndex] = lists[minIndex].next;
        }
        return retList;
    }

    public static void main(String[] args) {

    }
}
