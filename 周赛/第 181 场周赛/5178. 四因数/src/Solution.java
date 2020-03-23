public class Solution {
    public static int sumFourDivisors(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += find4FactorSums(num);
        }
        return (int)sum;
    }

    private static int find4FactorSums(int num) {
        int cnt = 0;
        int sum = 0;
        int i;
        for (i = 1; i * i < num; i++) {
            if (cnt > 4) {
                return 0;
            }
            if (num % i == 0) {
                sum = sum + i + num / i;
                cnt = cnt + 2;
            }
        }
        if (i * i == num) {
            cnt++;
            sum += i;
        }
        if (cnt == 4) {
            return sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{21,6,4,1}));
    }
}
