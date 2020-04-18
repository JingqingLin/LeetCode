// 官方题解：双指针法（移动较短的那根）
// 由于面积取决于边长短的那一端假设为 m，所以要想得到比当前更大的面积，
// 边长短的那一端必须舍弃，因为如果不舍弃，高最大就是 m，而随着指针的移动宽会一直减小，因此面积只会越来越小。

public class Solution {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max((height[i] < height[j]) ? (j - i) * height[i] : (j - i) * height[j], maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
