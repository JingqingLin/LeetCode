public class Solution {
    /**
     *  如何从桶 a = 13 和 b = 15 两个桶倒出 1 呢？
     *  1. a 装满，倒给 b；a 再装满，再倒给 b，此时 a 这个桶剩 11
     *  2. 11 倒给 b；装满 a，再倒给 b，此时 a 剩 9...
     *  3. 以此类推
     *  */
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        int gcd = gcd(a, b);
        return z <= x + y && z % gcd == 0;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(canMeasureWater(15, 13, 3));
    }
}
