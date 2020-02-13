import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int m, n;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, canReachP);
            dfs(matrix, i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, canReachP);
            dfs(matrix, m - 1, i, canReachA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }

    private static void dfs(int[][] matrix, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(matrix, nextR, nextC, canReach);
        }
    }

    public static void main(String[] args) {

    }
}
