public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p < 0) {
                nums1[i] = nums2[q];
                q--;
            } else if (q < 0) {
                // 剩余的 nums1 摆放在原位置不用移动
                break;
            } else if (nums1[p] >= nums2[q]) {
                nums1[i] = nums1[p];
                p--;
            } else {
                nums1[i] = nums2[q];
                q--;
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
