public class Solution {
    /**
     * 分割为两个 sum / 2 的 0-1 背包问题
     * dp[i][j] 表示从数组的 [1, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum / 2 + 1];
        if (nums[0] < sum / 2) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == nums[i]) {
                    dp[i][j] = true;
                } else if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum / 2];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
