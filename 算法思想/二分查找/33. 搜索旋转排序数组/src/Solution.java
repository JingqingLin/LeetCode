public class Solution {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 找出最小值
        int l = 0, r = len - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        // target 与 旋转点比较
        if (nums[len - 1] >= target) {
            l = r;
            r = len - 1;
        }
        else {
            l = 0;
            r--;
        }
        // 在左半部分或右半部分搜索
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }
}
