import java.util.LinkedList;

public class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = pushed.length;
        int push = 0, pop = 0;
        while (push < len) {
            while (push < len) {
                if (pushed[push] != popped[pop]) {
                    stack.push(pushed[push]);
                    push++;
                    continue;
                }
                stack.push(pushed[push]);
                break;
            }
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
            push++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 3, 5, 1}));
    }
}
