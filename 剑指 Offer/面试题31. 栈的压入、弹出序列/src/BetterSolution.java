import java.util.LinkedList;

public class BetterSolution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushed[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 3, 5, 1}));
    }
}
