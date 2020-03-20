public class Solution {
    /** 这题描述不严谨：
     *  中间过程的水可以放到其他地方的 */
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
