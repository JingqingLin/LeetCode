import java.util.LinkedList;

public class Solution {
    static class MaxQueue {
        private LinkedList<Integer> queue;
        private LinkedList<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            queue.offerLast(value);
            deque.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int head = queue.peekFirst();
            queue.pollFirst();
            if (!deque.isEmpty() && head == deque.peekFirst()) {
                deque.pollFirst();
            }
            return head;
        }
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.push_back(1);
        obj.push_back(2);
        obj.push_back(3);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}
