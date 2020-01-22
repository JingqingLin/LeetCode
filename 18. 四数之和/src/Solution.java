// 根据”三数之和“修改，并根据论坛里的方法进行情况修剪

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // j = i + 1, l, r
        for (int i = 0; i < len - 3; i++) {
            // 若 nums[i] > target 且为正，直接返回
            if (nums[i] > target && nums[i] > 0) {
                return result;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 最小值大于 target 则跳过
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                continue;
            }
            // 最大值小于 target 则跳过
            if (nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // 同上，判断最大最小值并跳过
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[len-2] + nums[len-1] < target) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l-1]) {
                        l++;
                        continue;
                    }
                    if (r < len - 1 && nums[r] == nums[r+1]) {
                        r--;
                        continue;
                    }

                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (temp < target) {
                        l++;
                    }
                    else if (temp > target) {
                        r--;
                    }
                    else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        l++;r--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String []args) {
        long  startTime = System.currentTimeMillis();
        System.out.println(fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
