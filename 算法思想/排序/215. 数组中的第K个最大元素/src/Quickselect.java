import java.util.Random;

public class Quickselect {
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int j = randPrtition(nums, l, r);
            if (j == k) {
                return nums[j];
            }
            if (j < k) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return nums[k];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /** 返回 pivot 下标 */
    private static int randPrtition(int[] nums, int l, int r) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int pivot = nums[p];
        // pivot 与 nums[l] 交换
        swap(nums, p, l);
        while (l < r) {
            // 一定要先左移右指针，因为首次左移停止后，被覆盖的 nums[l] 是 pivot 的值，不会影响原数组
            // 并且不能 r 移动时 nums[r] >= pivot，l 移动时 nums[l] < pivot
            // 因为若 nums[r] 的值刚好为 pivot 时，赋给 nums[l]，l 就动不起来了
            while (l < r && nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        // l r 相遇，pivot 存到 nums[l]
        nums[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
