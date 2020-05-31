public class BruteForce {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

//        for (int i = 0; i < heights.length; i++) {
//            int minHeight = heights[i];
//            for (int j = i; j < heights.length; j++) {
//                int width = j - i + 1;
//                minHeight = Math.min(minHeight, heights[j]);
//                maxArea = Math.max(maxArea, width * minHeight);
//            }
//        }

        for (int mid = 0; mid < heights.length; mid++) {
            // 枚举高
            int height = heights[mid];
            int left = mid, right = mid;
            // 确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= height) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
