public class Solution {
    public static int findMaxForm(String[] strs, int m, int n) {
        // dp(i, j) 表示使用 i 个 0 和 j 个 1 最多能拼出的字符串数目
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeroNums = 0, oneNums = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroNums++;
                } else {
                    oneNums++;
                }
            }
            for (int i = m; i >= zeroNums; i--) {
                for (int j = n; j >= oneNums; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroNums][j - oneNums]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        // {"10", "0", "1"}
    }
}
