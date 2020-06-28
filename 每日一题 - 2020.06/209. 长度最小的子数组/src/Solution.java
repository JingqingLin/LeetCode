public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        int sum = 0, len = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= s) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(12, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
