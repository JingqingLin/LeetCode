import java.util.*;

public class Solution {
    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(n);
        int queueSize;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            cnt++;
            while (queueSize-- > 0) {
                int remainder = queue.poll();
                for (int i : squares) {
                    int next = remainder - i;
                    if (next < 0) {
                        continue;
                    }
                    if (next == 0) {
                        return cnt;
                    }
                    queue.offer(next);
                }
            }

        }
        return n;
    }

    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            squares.add(0,i * i);
            i++;
        }
        return squares;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int a = numSquares(7168);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(a);
    }
}
