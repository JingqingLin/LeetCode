import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] rangeIndex = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0) {
            return rangeIndex;
        }
        // 先找左端点
        int l = 0, r = len - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        if (nums[l] != target) {
            return rangeIndex;
        }
        rangeIndex[0] = l;
        // 再找右端点
        r = len - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        rangeIndex[1] = r;
        return rangeIndex;
    }

    public static void main(String[] args) {
        int [] result = searchRange(new int[]{1,2,3,3,4,4,6,6,9,9}, 5);
        System.out.println(Arrays.toString(result));
    }
}
