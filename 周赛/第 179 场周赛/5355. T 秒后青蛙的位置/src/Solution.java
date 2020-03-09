import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<Integer> path;
    private static double possibility;

    /** 若目标结点有儿子，则时间要等于路径长度
     *  若目标结点无儿子，则时间要大于等于路径长度
     *  否则概率为 0
     * */

    public static double frogPosition(int n, int[][] edges, int t, int target) {
        possibility = 1;
        path = new ArrayList<>();
        for (int[] edge : edges) {
            int temp;
            if (edge[0] > edge[1]) {
                temp = edge[0];
                edge[0] = edge[1];
                edge[1] = temp;
            }
        }
        boolean hasPostNode = false;
        for (int[] edge : edges) {
            if (edge[0] == target) {
                hasPostNode = true;
                break;
            }
        }
        findPath(edges, target);
        path.add(0, 1);
        if (hasPostNode && t + 1 == path.size() || !hasPostNode && t + 1 >= path.size()) {
            BFS(edges, 0);
            return possibility;
        } else {
            return 0.0;
        }
    }

    private static void findPath(int[][] edges, int target) {
        for (int[] edge : edges) {
            if (edge[1] == target) {
                path.add(0, target);
                findPath(edges, edge[0]);
            }
        }
    }

    private static void BFS(int[][] edges, int pathIndex) {
        int cnt = 0;
        for (int[] edge : edges) {
            if (pathIndex < path.size() && edge[0] == path.get(pathIndex)) {
                cnt++;
            }
        }
        if (pathIndex + 1 == path.size()) {
            return;
        }
        possibility = possibility * 1.0 / cnt;
        BFS(edges, pathIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(frogPosition(3, new int[][]{{2, 1}, {3, 2}}, 1, 2));
    }
}
