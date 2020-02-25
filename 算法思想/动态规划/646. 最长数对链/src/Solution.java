import java.util.Arrays;

public class Solution {
    public static int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int preMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1] && dp[j] > preMax) {
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
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
