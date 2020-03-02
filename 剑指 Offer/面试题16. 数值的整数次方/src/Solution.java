public class Solution {
    public static double myPow(double x, int n) {
        long N = n;
        N = Math.abs(N);
        x = n > 0 ? x : 1 / x;
        double res = 1;
        while (N >= 1) {
            if (N % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            N = N / 2;
        }
        return res;
    }

    public static double fastpow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastpow(x, n / 2);
        if (n % 2 == 1) {
            return x * half * half;
        }
        return half * half;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 0));
    }
}
