import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 最好先创建一个 char[][]，并在此放置皇后，当 n == row 时，直接加入 char[]
     * 否则全部操作都在 n == row 时进行，会很慢
     */
    private static char[][] nQueens;
    private static boolean[] columnUsed;
    private static boolean[] topLeftUsed;
    private static boolean[] topRightUsed;
    private static int n;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        columnUsed = new boolean[n];
        topLeftUsed = new boolean[2 * n - 1];
        topRightUsed = new boolean[2 * n - 1];
        Solution.n = n;
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        backtrace(solution, 0);
        return solution;
    }

    private static void backtrace(List<List<String>> solution, int row) {
        if (n == row) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(String.valueOf(chars));
            }
            solution.add(list);
            return;
        }
        for (int column = 0; column < n; column++) {
            int topLeftIndex = column + n - 1 - row;
            int topRightIndex = column + row;
            if (columnUsed[column] || topLeftUsed[topLeftIndex] || topRightUsed[topRightIndex]) {
                continue;
            }
            nQueens[row][column] = 'Q';
            columnUsed[column] = topLeftUsed[topLeftIndex] = topRightUsed[topRightIndex] = true;
            backtrace(solution, row + 1);
            columnUsed[column] = topLeftUsed[topLeftIndex] = topRightUsed[topRightIndex] = false;
            nQueens[row][column] = '.';
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
