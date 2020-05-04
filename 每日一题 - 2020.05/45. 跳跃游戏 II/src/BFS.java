import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        boolean[] hasVisited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            while (size-- > 0) {
                int tempIndex = queue.poll();
                for (int i = 0; i <= nums[tempIndex]; i++) {
                    int jumpIndex = tempIndex + i;
                    if (jumpIndex < nums.length && !hasVisited[jumpIndex]) {
                        if (jumpIndex == nums.length - 1) {
                            return layer;
                        }
                        queue.add(jumpIndex);
                        hasVisited[jumpIndex] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{3}));
    }
}
