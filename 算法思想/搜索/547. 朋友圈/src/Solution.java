public class Solution {
    private static int m, n;

    public static int findCircleNum(int[][] M) {
        m = M.length;
        n = m == 0 ? 0 : M[0].length;
        if (m != n) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += isFriend(M, i);
        }
        return cnt;
    }

    private static int isFriend(int[][] grid, int x) {
        int flag = 0;
        for (int j = 0; j < n; j++) {
            if (grid[x][j] == 1) {
                grid[x][j] = 0;
                grid[j][x] = 0;
                isFriend(grid, j);
                flag = 1;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(
                new int[][]{
                        {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                        {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                        {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                        {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                        {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                        {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}}));
    }
}
