public class Solution {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int last = nums[0];
        int maxSum = last;
        for (int i = 1; i < nums.length; i++) {
            if (last <= 0) {
                last = nums[i];
            }
            else {
//                last = Math.max(0, last + nums[i]);
                last = last + nums[i];
            }
            maxSum = Math.max(maxSum, last);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 3, 4, -2, 3, 2, -3, 4}));
    }
}