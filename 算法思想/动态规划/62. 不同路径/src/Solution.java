public class Solution {
    public static int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        // 使 m 为两数之和，n 为较小的数
        if (n > m) {
            int temp = n - 1;
            n = m - 1;
            m = temp + n;
        } else {
            n = n - 1;
            m = n + m - 1;
        }
        System.out.printf("m %d; n %d\n", m, n);
        long res = 1;
        int times = 1;
        for (int i = 0; i < n; i++) {
            res = res * m-- / times++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }
}
