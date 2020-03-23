import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if (m == 1 && n == 1) {
            return true;
        }
        boolean[][] hasVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];

                int[][] direction = direction(grid[x][y]);
                for (int[] d : direction) {
                    int i = x + d[0], j = y + d[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !hasVisited[i][j]) {
                        int[][] newDirection = direction(grid[i][j]);
                        int[] newd1 = newDirection[0];
                        int[] newd2 = newDirection[1];
                        if ((newd1[0] == -d[0] && newd1[1] == -d[1] || newd2[0] == -d[0] && newd2[1] == -d[1])) {
                            if (i == m - 1 && j == n - 1) {
                                return true;
                            }
                            queue.add(new int[]{i, j});
                            hasVisited[i][j] = true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int[][] direction(int n) {
        int[][] dire;
        if (n == 2) {
            dire = new int[][]{{1, 0}, {-1, 0}};
        } else if (n == 1) {
            dire = new int[][]{{0, 1}, {0, -1}};
        } else if (n == 3) {
            dire = new int[][]{{0, -1}, {1, 0}};
        } else if (n == 4) {
            dire = new int[][]{{0, 1}, {1, 0}};
        } else if (n == 5) {
            dire = new int[][]{{0, -1}, {-1, 0}};
        } else if (n == 6) {
            dire = new int[][]{{0, 1}, {-1, 0}};
        } else {
            dire = new int[2][2];
        }
        return dire;
    }

    public static void main(String[] args) {
        System.out.println(hasValidPath(new int[][]{{1}}));
    }
}
