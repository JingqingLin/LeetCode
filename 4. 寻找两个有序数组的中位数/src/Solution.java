public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int j1 = nums1.length,j2 = nums2.length;
        if (j1 == 0) {
            return (double) (nums2[(j2 - 1)/2]+nums2[j2/2])/2;
        }
        else if (j2 == 0) {
            return (double) (nums1[(j1 - 1)/2]+nums1[j1/2])/2;
        }
        else {
            int left = (j1 + j2 + 1) / 2;
            int right = (j1 + j2 + 2) / 2;
            // left/right 代表奇偶的情况
            return (getKth(nums1, 0, j1 - 1, nums2, 0, j2 - 1, left) + getKth(nums1, 0, j1 - 1, nums2, 0, j2 - 1, right)) * 0.5;
        }
    }
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 数组剩余长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 始终让剩余长度较短的数组为 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        // len1 == 0 或 k == 1 时递归结束
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2);
        int j = start2 + Math.min(len2, k / 2);

        if (nums1[i-1] > nums2[j-1]) {
            return getKth(nums1, start1, end1, nums2, j, end2, k - (Math.min(len2, k / 2)));
        }
        else {
            return getKth(nums1, i, end1, nums2, start2, end2, k - (Math.min(len1, k / 2)));
        }
    }
    public static void main(String []args) {
        System.out.println(findMedianSortedArrays(new int[]{2,3,4,5},new int[]{9}));
    }
}