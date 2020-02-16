import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combineList = new ArrayList<>();
        generateCombination(combineList, new ArrayList<>(), 1, n, k);
        return combineList;
    }

    private static void generateCombination(
            List<List<Integer>> combineList, List<Integer> combine, int cursorPos, int n, int k) {
        if (k == 0) {
            combineList.add(new ArrayList<>(combine));
            return;
        }
        // i <= n - k + 1 剪枝
        for (int i = cursorPos; i <= n && i <= n - k + 1; i++) {
            // combine 用栈存储也可以，退出递归时只要直接 pop() 就行了
            combine.add(i);
            generateCombination(combineList, combine, i + 1, n, k - 1);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
