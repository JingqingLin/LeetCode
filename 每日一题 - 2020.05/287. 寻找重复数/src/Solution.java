public class Solution {
    public static int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 3, 4, 2}));
    }
}
