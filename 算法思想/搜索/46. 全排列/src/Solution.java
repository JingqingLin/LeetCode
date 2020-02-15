import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        generatePermute(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private static void generatePermute(
            List<List<Integer>> permuteList, List<Integer> permute, int[] nums, int cursorPos) {
        if (cursorPos == nums.length) {
            // 必须要 new 一个 list，否则在退出递归时，后方的 list.remove 会把 list 清空
            permuteList.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i <= cursorPos; i++) {
            permute.add(i, nums[cursorPos]);
            generatePermute(permuteList, permute, nums, cursorPos + 1);
            permute.remove(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
