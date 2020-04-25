public class Solution {
    public static int waysToChange(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(100000));
    }
}
