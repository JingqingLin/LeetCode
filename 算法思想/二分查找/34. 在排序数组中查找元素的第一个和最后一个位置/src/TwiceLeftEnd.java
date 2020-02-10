import java.util.Arrays;

// 找两次左端点
public class TwiceLeftEnd {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private static int findFirst(int[] nums, int target) {
        // 注意 h 的初始值
//        对于 findFirst([2,2], 3) ，我们希望返回 3 插入 nums 中的位置，也就是数组最后一个位置再往后一个位置，
//        即 nums.length。所以我们需要将 h 取值为 nums.length
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[]{1, 2, 3, 3, 4, 4, 6, 6, 9, 9}, 6);
        System.out.println(Arrays.toString(result));

    }
}
