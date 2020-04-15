import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;

        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] hasVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    hasVisited[i][j] = true;
                }
            }
        }

        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            while (size-- > 0) {
                int[] temp = queue.poll();
                for (int[] d : direction) {
                    int i = d[0] + temp[0], j = d[1] + temp[1];
                    if (i < 0 || j < 0 || i >= m || j >= n || hasVisited[i][j]) {
                        continue;
                    }
                    matrix[i][j] = layer;
                    hasVisited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
