import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        generatePermute(lists, new ArrayList<>(), nums);
        return lists;
    }

    /**
     * permuteLists 存储全排列
     * list 存储其中一个排列
     */
    private static void generatePermute(
            List<List<Integer>> permuteLists, List<Integer> list, int[] nums) {
        int listSize = list.size();
        if (listSize == nums.length) {
            // 必须要 new 一个 list 再 add，因为 list 是引用传递
            // 在退出递归时 list.remove 会把 list 清空，permuteLists 也会变空
            permuteLists.add(new ArrayList<>(list));
            return;
        }
        // 对于每一个长度为 n 的序列来说，有 n + 1 个插入位置
        for (int i = 0; i <= listSize; i++) {
            list.add(i, nums[listSize]);
            generatePermute(permuteLists, list, nums);
            list.remove(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
