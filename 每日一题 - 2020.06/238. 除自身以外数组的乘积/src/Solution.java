import java.util.Arrays;

public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n + 2];
        int[] backward = new int[n + 2];
        forward[0] = 1;
        backward[n + 1] = 1;
        int[] product = new int[n];

        for (int i = 0; i < n; i++) {
            forward[i + 1] = forward[i] * nums[i];
            backward[n - i] = backward[n + 1 - i] * nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            product[i] = forward[i] * backward[i + 2];
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
