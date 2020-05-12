public class Solution {
    public static double myPow(double x, long n) {
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        if (n == 0) {
            return 1;
        }
        double half = myPow(x, n / 2);
        if (n % 2 != 0) {
            return half * half * x;
        }
        return half * half;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -4));
    }
}
