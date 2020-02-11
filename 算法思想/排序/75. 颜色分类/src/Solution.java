public class Solution {
    public static void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                // 从 two 指针交换过来的可能是 0/1/2，所以 one 指针不能动，下一轮继续判断这个位置的 one
                swap(nums, --two, one);
            } else {
                // one 指针前进了，而 zero 指针停在了 1 之前
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
        sortColors(new int[]{0, 2, 1, 0, 2, 2});
    }
}
