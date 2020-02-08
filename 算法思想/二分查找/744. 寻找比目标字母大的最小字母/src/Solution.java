public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int diff = letters[m] - target;
            if (diff <= 0) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return letters[l % len];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'z'));
//        letters = ["c", "f", "j"]
//        target = "g"
    }
}
