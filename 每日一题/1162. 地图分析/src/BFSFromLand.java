import java.util.LinkedList;
import java.util.Queue;

/**
 * 和“腐烂的橘子”一模一样
 */
public class BFSFromLand {
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int layer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                for (int[] d : direction) {
                    int i = temp[0] + d[0], j = temp[1] + d[1];
                    if (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0) {
                        grid[i][j] = 1;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            layer++;
        }
        return layer == 0 ? -1 : layer;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
