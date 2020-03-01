import java.util.LinkedList;

public class Solution {
    static class CQueue {
        private static LinkedList<Integer> A, B;
        public CQueue() {
            A = new LinkedList<>();
            B = new LinkedList<>();
        }

        public static void appendTail(int value) {
            A.push(value);
        }

        public static int deleteHead() {
            if (!B.isEmpty()) {
                return B.pop();
            } else {
                if (A.isEmpty()) {
                    return -1;
                } else {
                    while (!A.isEmpty()) {
                        B.push(A.pop());
                    }
                    return B.pop();
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}