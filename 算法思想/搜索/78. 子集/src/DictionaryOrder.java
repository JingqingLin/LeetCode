import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DictionaryOrder {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length != 0) {
            generateSubset(subsetList, nums, 0);
        }
        subsetList.add(new ArrayList<>());
        return subsetList;
    }

    private static void generateSubset(List<List<Integer>> subsetList, int[] nums,
                                       int cursorPos) {
        int tempNum = nums[cursorPos];
        subsetList.add(new ArrayList<>(Collections.singletonList(tempNum)));
        int size = subsetList.size() - 1;
        List<Integer> tempList;
        for (int i = 0; i < size; i++) {
            tempList = new ArrayList<>(subsetList.get(i));
            tempList.add(tempNum);
            subsetList.add(new ArrayList<>(tempList));
        }
        if (cursorPos + 1 < nums.length) {
            generateSubset(subsetList, nums, cursorPos + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{}));
    }
}
