import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = len - 1; i >= 0; i--) {
            int curTemperature = T[i];
            int daysToWait = 0;
            while (!stack.isEmpty()) {
                if (T[stack.getLast()] > curTemperature) {
                    daysToWait = stack.getLast() - i;
                    break;
                }
                stack.pollLast();
            }
            res[i] = daysToWait;
            stack.addLast(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
