import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length != 0) {
            generateSubset(subsetList, nums, 0, 0);
        }
        subsetList.add(new ArrayList<>());
        return subsetList;
    }

    /** 去重：若 nums[i] == nums[i - 1]，则仅对上一轮加入的元素进行添加 */
    private static void generateSubset(List<List<Integer>> subsetList, int[] nums,
                                       int numsCursor, int listCursor) {
        int i = listCursor;
        int tempNum = nums[numsCursor];
        int size = subsetList.size();
        List<Integer> tempList;
        if (numsCursor == 0 || nums[numsCursor - 1] != nums[numsCursor]) {
            i = 0;
            subsetList.add(new ArrayList<>(Collections.singletonList(tempNum)));
            size = subsetList.size() - 1;
        }
        for (; i < size; i++) {
            tempList = new ArrayList<>(subsetList.get(i));
            tempList.add(tempNum);
            subsetList.add(new ArrayList<>(tempList));
        }
        if (numsCursor + 1 < nums.length) {
            generateSubset(subsetList, nums, numsCursor + 1, size);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
