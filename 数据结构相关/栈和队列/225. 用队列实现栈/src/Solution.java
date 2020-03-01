import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    static class MyStack {
        private static Deque<Integer> deque;

        /** Initialize your data structure here. */
        public MyStack() {
            deque = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public static void push(int x) {
            deque.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public static int pop() {
            return deque.removeLast();
        }

        /** Get the top element. */
        public static int top() {
            return deque.getLast();
        }

        /** Returns whether the stack is empty. */
        public static boolean empty() {
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
