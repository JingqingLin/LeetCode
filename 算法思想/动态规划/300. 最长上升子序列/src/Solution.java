public class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int preMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && dp[j] > preMax) {
                    dp[i] = dp[j] + 1;
                    preMax = dp[j];
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 11}));
    }
}
