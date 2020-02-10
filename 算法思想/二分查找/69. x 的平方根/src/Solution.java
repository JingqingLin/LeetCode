public class Solution {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int div = x / m;
            if (div == m) {
                return m;
            }
            if (m > div) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
}
