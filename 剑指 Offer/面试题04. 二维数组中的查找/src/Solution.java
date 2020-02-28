public class Solution {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (n == 0) {
            return false;
        }
        // 右上角或左下角开始查找
        int row = 0, col = n - 1;
        while (row < m && col >=0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 20));
    }
}
