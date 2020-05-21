public class DynamicProgramming {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1, startPos = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1) {
                if (chars[i] == chars[i + 1]) {
                    dp[i][i + 1] = true;
                    maxLen = 2;
                    startPos = i;
                }
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                int j = i + l - 1;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = l;
                    startPos = i;
                }
            }
        }
        return s.substring(startPos, startPos + maxLen);
    }

    public static void main(String[] args) {
        String a = "abacab";
        System.out.println(longestPalindrome(a));
    }
}
