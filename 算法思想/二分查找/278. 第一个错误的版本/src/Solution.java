public class Solution {
    static final int firstBadIndex = 1;

    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static boolean isBadVersion(int n) {
        return n >= firstBadIndex;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(8));
    }
}
