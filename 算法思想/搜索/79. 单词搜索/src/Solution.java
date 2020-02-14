public class Solution {
    private static int m, n;
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean flag;

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        m = board.length;
        n = m == 0 ? 0 : board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(hasVisited, board, word, i, j);
                    if (flag == true) {
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private static void dfs(boolean[][] hasVisited, char[][] board, String word, int x, int y) {
        if (word.length() == 1) {
            flag = true;
            return;
        }
        hasVisited[x][y] = true;
        for (int[] d : direction) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n &&
                    board[nextX][nextY] == word.charAt(1) && !hasVisited[nextX][nextY]) {
                dfs(hasVisited, board, word.substring(1), nextX, nextY);
            }
        }
        hasVisited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'F','B','C','E'},{'S','F','C','S'}};
        System.out.println(exist(board, "FBCC"));
    }
}
