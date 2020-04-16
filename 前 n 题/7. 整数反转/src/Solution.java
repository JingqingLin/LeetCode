public class Solution {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            if (result > 214748364 || result < -214748364) {
                return 0;
            }
            result = 10 * result + temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(2147483642
        ));
    }
}
