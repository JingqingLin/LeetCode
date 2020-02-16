import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            combinationSum.add(candidates[i]);
            // 因为允许 candidates 中的数字可以无限制重复被选取，所以 cursorPos = i，而非 i + 1
            generateCombinationSum(combinationSumList, combinationSum,
                    i, candidates, residue - candidates[i]);
            combinationSum.remove(combinationSum.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 4, 6, 7}, 7));
    }
}
