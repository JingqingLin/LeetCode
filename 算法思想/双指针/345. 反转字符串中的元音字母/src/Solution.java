public class Solution {
    public static String reverseVowels(String s) {
        char[] result = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (isVowel(result[l]) &&
                    isVowel(result[r]) && l < r) {
                result[l] = s.charAt(r);
                result[r] = s.charAt(l);
                l++;
                r--;
            }
            while (!isVowel(result[l]) && l < r) {
                l++;
            }
            while (!isVowel(result[r]) && l < r) {
                r--;
            }
        }
        return String.valueOf(result);
    }

    public static boolean isVowel(char c) {
        return c == 65 || c == 69 || c == 73 || c == 79 || c == 85 || c == 97 || c == 101 || c == 105 || c == 111 || c == 117;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leaeou"));
    }
}
