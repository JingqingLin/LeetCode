import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) == null) {
                int leftLen = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int rightLen = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int curLen = leftLen + rightLen + 1;
                map.put(num, curLen);
                map.put(num + rightLen, curLen);
                map.put(num - leftLen, curLen);
                maxLength = Math.max(maxLength, curLen);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,101,5,102,99,4,200,1,3,2,103,98}));
    }
}
