public class Solution {
    public static int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        System.out.printf("index: %d\n", r);
        return nums[r];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{10, 18, 10, 10, 10, 10}));
        System.out.println(findMin(new int[]{2, 2, 2, 2, 0, 1}));
        // 2 2 2 0 1
        // 10 1 10 10 10 10
        // 10 18 10 10 10 10
    }
}
