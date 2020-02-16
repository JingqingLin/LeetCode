import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinationSumList = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinationSum(combinationSumList, new ArrayList<>(), 0, candidates, target);
        return combinationSumList;
    }

    private static void generateCombinationSum(
            List<List<Integer>> combinationSumList, List<Integer> combinationSum,
            int cursorPos, int[] candidates, int residue) {
        if (residue == 0) {
            combinationSumList.add(new ArrayList<>(combinationSum));
            return;
        }
        for (int i = cursorPos; i < candidates.length && residue - candidates[i] >= 0; i++) {
            // 去重
            if (i != cursorPos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combinationSum.add(candidates[i]);
            // 因为 candidates 中的数字只能使用一次，所以 cursorPos = i + 1
            generateCombinationSum(combinationSumList, combinationSum,
                    i + 1, candidates, residue - candidates[i]);
            combinationSum.remove(combinationSum.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
