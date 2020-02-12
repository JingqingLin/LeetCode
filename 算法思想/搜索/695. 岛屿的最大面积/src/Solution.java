public class Solution {
    private static int m;
    private static int n;
    private static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, DFS(grid, i, j));
            }
        }
        return maxArea;
    }

    private static int DFS(int[][] grid, int x, int y) {
        if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] == 0) {
            return 0;
        }
        int area = 1;
        grid[x][y] = 0;
        for (int[] d : direction) {
            area += DFS(grid, x + d[0], y + d[1]);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(
                new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }
}
