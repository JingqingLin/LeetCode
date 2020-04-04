public class Solution {
    public static int trap(int[] height) {
        int len = height.length;
        int start = 0, end = len - 1;
        for (int i = 0; i < len - 1; i++) {
            if (height[i] > height[i + 1]) {
                start = i;
                break;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (height[i] > height[i - 1]) {
                end = i;
                break;
            }
        }
        int area = 0;
        int left = start, right;
        for (int i = start + 1; i <= end; i++) {
            if (height[i - 1] < height[i] && (i == end || height[i] >= height[i + 1])) {
                right = i;
                int minHeight = Math.min(height[left], height[right]);
                for (int j = left + 1; j < right; j++) {
                    if (minHeight > height[j]) {
                        area = area + minHeight - height[j];
                        height[j] = minHeight;
                    }
                }
                if (height[right] > height[left]) {
                    left = right;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
    }
}
