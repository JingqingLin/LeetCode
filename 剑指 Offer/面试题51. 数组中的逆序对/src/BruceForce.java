public class BruceForce {
    /**
     * 暴力法力扣超时
     */
    public static int reversePairs(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            for (int j = 0; j < i; j++) {
                if (key < nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }
}
