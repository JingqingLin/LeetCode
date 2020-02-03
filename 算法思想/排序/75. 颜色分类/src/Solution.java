public class Solution {
    public static void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            }
            else if (nums[one] == 2) {
                swap(nums, --two, one);
            }
            else {
                ++one;
            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        sortColors(new int[]{0, 2, 1, 0, 0, 1});
    }
}
