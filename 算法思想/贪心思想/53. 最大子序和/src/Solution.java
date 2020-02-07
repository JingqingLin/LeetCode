public class Solution {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            if (preSum <= 0) {
                preSum = nums[i];
            }
            else {
//                preSum = Math.max(0, preSum + nums[i]);
                preSum = preSum + nums[i];
            }
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 3, 4, -2, 3, 2, -3, 4}));
    }
}