public class Solution {
    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
        }
        // 若有 n 倍关系，则翻 n 倍，就加 n 步
        for (int i = 2; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(2));
    }
}
