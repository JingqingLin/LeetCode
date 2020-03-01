public class Solution {
    public static int movingCount(int m, int n, int k) {
        return 1;
    }

    private static boolean digitsSum(int m, int n, int k) {
        int sumM = 0, sumN = 0;
        while (m != 0) {
            sumM += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sumN += n % 10;
            n = n / 10;
        }
        return sumM + sumN < k;
    }

    public static void main(String[] args) {
        System.out.println(digitsSum(35, 37, 18));
    }
}
