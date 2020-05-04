public class Greedy {
    public static int jump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i <= rightMost) {
                if (rightMost < i + nums[i]) {
                    rightMost = i + nums[i];
                    for (int j = i + 1; j <= rightMost && j < n; j++) {
                        cnt[j] = cnt[j] == 0 ? cnt[i] + 1 : Math.min(cnt[i] + 1, cnt[j]);
                    }
                }
                if (rightMost >= n - 1) {
                    return cnt[n - 1];
                }
            } else {
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{3}));
    }
}
