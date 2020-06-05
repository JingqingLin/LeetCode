import java.util.Arrays;

public class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (n == 0) {
            return new int[0];
        }
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] hasVisited = new boolean[m][n];
        int i = 0, row = 0, col = 0, direIdx = 0;
        int[] order = new int[m * n];

        int stepX = direction[direIdx][0];
        int stepY = direction[direIdx][1];
        do {
            order[i] = matrix[row][col];
            hasVisited[row][col] = true;

            if (row + stepX >= m || col + stepY >= n || row + stepX < 0 || col + stepY < 0 ||
                    hasVisited[row + stepX][col + stepY]) {
                direIdx = (direIdx + 1) % 4;
                stepX = direction[direIdx][0];
                stepY = direction[direIdx][1];
            }
            row = row + stepX;
            col = col + stepY;
        } while (++i < m * n);

        return order;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
