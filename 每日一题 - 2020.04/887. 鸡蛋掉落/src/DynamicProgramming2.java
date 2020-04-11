public class DynamicProgramming2 {
    public static int superEggDrop(int K, int N) {
        // N 层 K 蛋
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
        }

        // 蛋先遍历
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
                }
                dp[i][j] = min;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(superEggDrop(8, 10000));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
