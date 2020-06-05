import java.util.Arrays;

public class Solution2 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];

        product[0] = 1;
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] = product[i] * R;
            R *= nums[i];
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
