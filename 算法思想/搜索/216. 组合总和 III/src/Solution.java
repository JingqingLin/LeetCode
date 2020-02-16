import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinationSumList = new ArrayList<>();
        generateCombinationSum(combinationSumList, new ArrayList<>(), 1, k, n);
        return combinationSumList;
    }

    private static void generateCombinationSum(
            List<List<Integer>> combinationSumList, List<Integer> combinationSum,
            int cursorPos, int layer, int residue) {
        if (layer == 0 && residue == 0) {
            combinationSumList.add(new ArrayList<>(combinationSum));
            return;
        }
        for (int i = cursorPos; i <= 9 && residue - i >= 0; i++) {
            combinationSum.add(i);
            generateCombinationSum(combinationSumList, combinationSum,
                    i + 1, layer - 1, residue - i);
            combinationSum.remove(combinationSum.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
}
