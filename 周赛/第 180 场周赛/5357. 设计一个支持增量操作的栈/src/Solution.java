import java.util.LinkedList;

public class Solution {
    static class CustomStack {
        LinkedList<Integer> linkedList;
        int maxSize;

        public CustomStack(int maxSize) {
            linkedList = new LinkedList<>();
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (linkedList.size() < maxSize) {
                linkedList.addLast(x);
            }
        }

        public int pop() {
            return linkedList.isEmpty() ? -1 : linkedList.pollLast();
        }

        public void increment(int k, int val) {
            k = Math.min(linkedList.size(), k);
            for (int i = 0; i < k; i++) {
                linkedList.set(i, linkedList.get(i) + val);
            }
        }
    }

    public static void main(String[] args) {
        CustomStack obj = new CustomStack(1000);
        obj.push(2);
        int param_2 = obj.pop();
    }
}
