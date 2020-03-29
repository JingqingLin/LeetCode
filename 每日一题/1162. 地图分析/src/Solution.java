import java.util.LinkedList;
import java.util.Queue;

/**
 * 和“腐烂的橘子”差不多
 */
public class Solution {
    private static int[][] grid;
    private static int n;
    private static int[][] direction;

    public static int maxDistance(int[][] grid) {
        int maxDistance = -1;
        n = grid.length;
        Solution.grid = grid;
        direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 若为海洋，求最近的陆地距离
                if (grid[i][j] == 0) {
                    maxDistance = Math.max(maxDistance, BFS(i, j));
                }
            }
        }
        return maxDistance;
    }

    private static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        boolean[][] hasVisited = new boolean[n][n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                for (int[] d : direction) {
                    int x = d[0] + temp[0], y = d[1] + temp[1];
                    if (x >= 0 && y >= 0 && x < n && y < n && !hasVisited[x][y]) {
                        int distance = temp[2];
                        queue.add(new int[]{x, y, distance + 1});
                        if (grid[x][y] == 1) {
                            return distance + 1;
                        }
                        hasVisited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{{1}}));
    }
}
