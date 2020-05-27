public class Solution {
    public static int subarraysDivByK(int[] A, int K) {
        int cnt = 0;
        int len = A.length;
        long[] sum = new long[len];
        sum[0] = A[0];

        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++) {
            if (sum[i] % K == 0) {
                cnt++;
            }
            for (int j = i - 1; j >= 0; j--) {
                if ((sum[i] - sum[j]) % K == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
