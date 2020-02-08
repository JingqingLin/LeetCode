public class Solution {
    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            // m 为偶数，且 nums[m] == nums[m + 1] 或
            // m 为奇数，且 nums[m] != nums[m + 1] 时，单一元素在右半部分
            if (m % 2 == 0 && nums[m] == nums[m + 1] ||
                    m % 2 != 0 && nums[m] != nums[m + 1]) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,3,3,4}));
    }
}
