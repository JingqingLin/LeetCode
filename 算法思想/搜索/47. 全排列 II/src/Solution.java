import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permuteList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        generatePermute(permuteList, new ArrayList<>(), hasVisited, nums);
        return permuteList;
    }

    private static void generatePermute(
            List<List<Integer>> permuteList, List<Integer> permutes, boolean[] hasVisited, int[] nums) {
        if (permutes.size() == nums.length) {
            permuteList.add(new ArrayList<>(permutes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1] || hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            permutes.add(nums[i]);
            generatePermute(permuteList, permutes, hasVisited, nums);
            permutes.remove(permutes.size() - 1);
            hasVisited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
