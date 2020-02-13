public class Solution {
    private static int m, n;

    public static void solve(char[][] board) {
        m = board.length;
        n = m == 0 ? 0 : board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        // 先遍历四个边
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'L') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        if (x < m && y < n && x >= 0 && y >= 0 && board[x][y] == 'O') {
            board[x][y] = 'L';
            dfs(board, x + 1, y);
            dfs(board, x, y + 1);
            dfs(board, x - 1, y);
            dfs(board, x, y - 1);
        }
    }

    public static void main(String[] args) {
        solve(new char[][]
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
