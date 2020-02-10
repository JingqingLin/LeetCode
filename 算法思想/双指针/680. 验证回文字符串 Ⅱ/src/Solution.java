public class Solution {
    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == s.charAt(r) && l < r) {
            l++;
            r--;
        }
        if (l == r || l == r + 1) {
            return true;
        }
        int newl = l, newr = r - 1;
        l++;
        while (s.charAt(l) == s.charAt(r) && l < r) {
            l++;
            r--;
        }
        if (l == r || l == r + 1) {
            return true;
        }
        while (s.charAt(newl) == s.charAt(newr) && newl < newr) {
            newl++;
            newr--;
        }
        if (newl == newr || newl == newr + 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abcbcbba"));
    }
}
