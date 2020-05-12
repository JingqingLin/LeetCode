import java.util.LinkedList;

public class Solution {
    public static class MinStack {
        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            // addLast 和 push 不一样
            stack.addLast(x);
            if (minStack.isEmpty()) {
                minStack.addLast(x);
            } else if (x <= minStack.peekLast()) {
                minStack.addLast(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int x = stack.pollLast();
            if (!minStack.isEmpty() && minStack.peekLast() == x) {
                minStack.pollLast();
            }
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return minStack.getLast();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
