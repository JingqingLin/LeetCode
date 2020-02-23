public class Solution {
    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            char preChar = s.charAt(i - 2);
            char curChar = s.charAt(i - 1);
            if (curChar == '0') {
                if (preChar == '1' || preChar == '2') {
                    dp[i] = dp[i - 2];
                }
                else {
                    return 0;
                }
            } else {
                if (preChar == '1') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else if (preChar == '2' && curChar >= '1' && curChar <= '6') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("20"));
        // 2220
        // 22202
        // 230
        // 220012
        // 20
        // 012242
    }
}
