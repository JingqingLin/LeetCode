public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("", "ddd"));
    }
}