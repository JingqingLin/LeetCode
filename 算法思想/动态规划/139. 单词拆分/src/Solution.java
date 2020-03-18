import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 可被用多次，是完全背包问题
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        for (int i = 1; i <= sLen; i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (i >= len && dp[i - len] && str.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[sLen];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcodeand", Arrays.asList("leet", "code", "sand", "and", "cat")));
    }
}
