import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        // 直接对原数组进行升序排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                return result;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    if (nums[l] == nums[r]) {
                        break;
                    } else {
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
            while (nums[i] == nums[i + 1]) {
                i++;
                if (i == nums.length - 1) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> print = threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
        // -4 -1 -1 0 1 2
        for (List<Integer> array : print) {
            for (Integer i : array) {
                System.out.printf("%d ", i);
            }
            System.out.println("\n");
        }
    }
}
