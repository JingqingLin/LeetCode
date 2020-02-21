public class Solution {
    static class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            this.sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum[0] = nums[0];
                } else {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            }
            return sum[j] - sum[i - 1];
        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 5));
    }
}
