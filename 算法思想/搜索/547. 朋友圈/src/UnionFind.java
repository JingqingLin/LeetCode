import java.util.Arrays;

public class UnionFind {
    /** 查找并返回根结点编号 */
    static int find(int[] parent, int i) {
        // 如果是根结点，则返回根结点编号
        if (parent[i] == -1) {
            return i;
        }
        // 否则，递归查找父亲结点是不是根结点
        return find(parent, parent[i]);
    }

    /** 合并 */
    static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        // 若根结点不相同，则让 x 集合的根结点指向 y 集合的根结点，这样他们就指向相同的根结点了
        if (xset != yset) {
            parent[xset] = yset;
        }
    }

    public static int findCircleNum(int[][] M) {
        // 初始化父亲结点数组。一开始有 M.length 个集合，每个集合内只有一个元素，都是各自集合的根结点
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    // 如果他们是朋友，则把他们合并到一个集合。即，让他们指向相同的根结点
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int value : parent) {
            //
            if (value == -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(
                new int[][]{
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}}));
    }
}
