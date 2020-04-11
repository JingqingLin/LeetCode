public class DynamicProgramming1 {
    public static int superEggDrop(int K, int N) {
        // N 层 K 蛋
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
        }
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }

        // 层先遍历
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    min = Math.min(min, Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
                dp[i][j] = min;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(superEggDrop(8, 10000));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
