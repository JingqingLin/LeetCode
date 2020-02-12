public class Solution {
    private static int m, n;
    private static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = m == 0 ? 0 : grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt += isIsland(grid, i, j);
            }
        }
        return cnt;
    }

    private static int isIsland(char[][] grid, int x, int y) {
        if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] == '0') {
            return 0;
        }
        grid[x][y] = '0';
        for (int[] d : direction) {
            isIsland(grid, x + d[0], y + d[1]);
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}}));
    }
}
