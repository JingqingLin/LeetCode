public class Solution {
    public static int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        int verticalArea = 0, horizontalArea = 0;
        int topArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    verticalArea += grid[i][j];
                } else {
                    verticalArea += Math.abs(grid[i][j] - grid[i - 1][j]);
                }
                if (i == m - 1) {
                    verticalArea += grid[i][j];
                }

                if (j == 0) {
                    horizontalArea += grid[i][j];
                } else {
                    horizontalArea += Math.abs(grid[i][j] - grid[i][j - 1]);
                }
                if (j == n - 1) {
                    horizontalArea += grid[i][j];
                }

                if (grid[i][j] != 0) {
                    topArea++;
                }
            }
        }
        return topArea * 2 + verticalArea + horizontalArea;
    }

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{{2}}));
    }
}
