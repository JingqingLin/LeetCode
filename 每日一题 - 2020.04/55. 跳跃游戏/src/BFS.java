import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static boolean canJump(int[] nums) {
        boolean[] hasVisited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int tempIndex = queue.poll();
                for (int i = 0; i <= nums[tempIndex]; i++) {
                    int jumpIndex = tempIndex + i;
                    if (jumpIndex < nums.length && !hasVisited[jumpIndex]) {
                        if (jumpIndex == nums.length - 1) {
                            return true;
                        }
                        queue.add(jumpIndex);
                        hasVisited[jumpIndex] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
