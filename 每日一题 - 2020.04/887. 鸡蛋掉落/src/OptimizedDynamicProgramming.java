public class OptimizedDynamicProgramming {
    public static int superEggDrop(int K, int N) {
        // N 层 K 蛋
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
        }

        // 蛋先遍历 + 二分查找
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                int low = 2, high = j;
                while (low < high) {
                    int m = low + (high - low) / 2;
                    // y1 递增，y2 递减
                    int y1 = dp[i - 1][m - 1], y2 = dp[i][j - m];
                    if (y1 > y2) {
                        high = m - 1;
                    } else if (y1 < y2) {
                        low = m + 1;
                    } else {
                        low = high = m;
                    }
                }
                // low 和 high 有可能是不相等的 low - 1 = high，因为他们的交点不在整数层上
                if (low == high) {
                    dp[i][j] = Math.max(dp[i - 1][low - 1], dp[i][j - low]) + 1;
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i - 1][low - 1], dp[i][j - low]), Math.max(dp[i - 1][high - 1], dp[i][j - high])) + 1;
                }
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
