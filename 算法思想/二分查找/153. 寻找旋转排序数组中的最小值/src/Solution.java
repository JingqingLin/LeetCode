public class Solution {
    public static int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[0]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return nums[(r + 1) % len];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2, 3}));
    }
}
