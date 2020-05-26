public class Solution2 {
    public static int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;

        // 计算最高位数
        int bit_max = 0;
        while (((n - 1) >> bit_max) > 0) {
            bit_max++;
        }
        for (int bit = 0; bit < bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 3, 4, 2}));
    }
}
