public class Partition {
    public static int maxSubArray(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    public static int sum(int[] nums, int left, int right, int p) {
        if (left == right) {
            return nums[left];
        }

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public static int partition(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftSum = partition(nums, left, mid);
        int rightSum = partition(nums, mid + 1, right);
        int crossSum = sum(nums, left, right, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 3, 4, -2, 3, 2, -3, 4}));
    }
}
