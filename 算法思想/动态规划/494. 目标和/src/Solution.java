import java.util.Arrays;

public class Solution {
    private static int cnt;

    public static int findTargetSumWays(int[] nums, int S) {
        cnt = 0;
        DFS(nums, 0, 0, S);
        return cnt;
    }

    private static void DFS(int[] nums, int cursur, int sum, int S) {
        if (sum == S && cursur == nums.length) {
            cnt++;
            return;
        }
        if (cursur == nums.length) {
            return;
        }
        int sumPlus = sum + nums[cursur];
        int sumMinus = sum - nums[cursur];
        DFS(nums, cursur + 1, sumPlus, S);
        DFS(nums, cursur + 1, sumMinus, S);
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
