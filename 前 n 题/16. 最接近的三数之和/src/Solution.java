import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("No three sum solution");
        }
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
//                System.out.println(minDifference);
                if (minDifference > Math.abs(nums[i] + nums[l] + nums[r] - target)) {
                    minDifference = Math.abs(nums[i] + nums[l] + nums[r] - target);
                    result = nums[i] + nums[l] + nums[r];
                }

                if (nums[i] + nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
        // -4 -1 1 2
    }
}
