public class Solution {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String temp, temp1;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 分别初始化一字母回文和二字母回文(abbc)
            temp = isPalindrome(i, i, s);
            if (maxLen < temp.length()) {
                maxLen = temp.length();
                result = temp;
            }

            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                temp1 = isPalindrome(i, i + 1, s);
                if (maxLen < temp1.length()) {
                    maxLen = temp1.length();
                    result = temp1;
                }
            }

        }
        return result;
    }
    private static String isPalindrome(int start, int end, String s) {
        if (start-1 >=0 && end+1 <= s.length()-1 && s.charAt(start-1) == s.charAt(end+1)) {
            return isPalindrome(start - 1, end + 1, s);
        }
        else {
            System.out.printf("回文子串: %s\n", s.substring(start,end + 1));
            return s.substring(start,end + 1);
        }
    }
    public static void main(String []args) {
        String a = "bb";
        System.out.println(longestPalindrome(a));
    }
}
