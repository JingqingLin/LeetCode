public class Solution2 {
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            char preChar = str.charAt(i - 2);
            char curChar = str.charAt(i - 1);
            if (preChar == '1' || (preChar == '2' && curChar >= '0' && curChar <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
