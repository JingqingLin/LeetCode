public class MergeSort {
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        // temp 数组作为参数，可以不用在每次递归时新建 temp 数组，省点空间
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }


    /**
     * Partition 过程：把数组对半分
     */
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);

        // 已经有序
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }

        int crossCount = mergeAndCount(nums, left, mid, right, temp);

        return leftCount + crossCount + rightCount;
    }

    /**
     * Merge 过程：归并两个左右两个数组，同时计算逆序数
     */
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // i j 为指向两个数组 left 的指针
        int i = left, j = mid + 1, index = left;
        int count = 0;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[index++] = temp[i++];
            } else {
                count += mid - i + 1;
                nums[index++] = temp[j++];
            }
        }

        while (i <= mid) {
            nums[index++] = temp[i++];
        }
        while (j <= right) {
            nums[index++] = temp[j++];
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }
}
