public class ScanTwice {
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftScan = new int[len];
        int[] rightScan = new int[len];

        int leftMax = 0;
        for (int i = 0; i < len; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftScan[i] = leftMax;
        }
        int rightMax = 0;
        for (int i = len - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightScan[i] = rightMax;
        }
        int area = 0;
        for (int i = 0; i < len; i++) {
            area = area + Math.min(leftScan[i], rightScan[i]) - height[i];
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
    }
}
