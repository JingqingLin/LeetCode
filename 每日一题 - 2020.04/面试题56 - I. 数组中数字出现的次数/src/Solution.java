import java.util.Arrays;

public class Solution {

    public static int[] singleNumbers(int[] nums) {
        // 用于将所有的数异或起来
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        // 获得 k 中最低位的 1，说明这两个我们要找的数在这一位肯定不同，我们可以根据这一位分组
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }
}
