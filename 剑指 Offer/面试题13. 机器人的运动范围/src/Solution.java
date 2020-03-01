import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int movingCount(int m, int n, int k) {
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] hasVisited = new boolean[m][n];
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        hasVisited[0][0] = true;
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            while (layerSize-- > 0) {
                int[] xy = queue.poll();
                for (int[] d : direction) {
                    int nextX = d[0] + xy[0], nextY = d[1] + xy[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n ||
                            !digitsSum(nextX, nextY, k) || hasVisited[nextX][nextY]) {
                        continue;
                    }
                    cnt++;
                    hasVisited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return cnt;
    }

    private static boolean digitsSum(int m, int n, int k) {
        int sumM = 0, sumN = 0;
        while (m != 0) {
            sumM += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sumN += n % 10;
            n = n / 10;
        }
        return sumM + sumN <= k;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }
}
