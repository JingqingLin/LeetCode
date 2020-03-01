import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/two-sum/
public class Solution {
    static int[] twoSum(int[] nums, int target) {
//        for(int i = 0;i < nums.length-1;i++) {
//            for(int j = i+1;j < nums.length;j++) {
//                if(nums[i]+nums[j] == target) {
//                    return (new int[]{i, j});
//                }
//            }
//        }
//        return (new int[]{0,0});
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a;
        a = twoSum(new int[]{3, 3, 4}, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}