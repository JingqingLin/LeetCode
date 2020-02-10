public class Solution {
    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int descCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (i != 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                descCount++;
            }
            if (descCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
        // 改前还是改后，以及首位
        // -1 (4) 2 3
        //  3 3 (2) 3
        // 3 4 2 3
        // (4) 2 3
    }
}
