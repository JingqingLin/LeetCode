public class Solution {
    public static int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.contains(evil) && s2.contains(evil)) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = n - 1; i >= 0; i--) {

        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
