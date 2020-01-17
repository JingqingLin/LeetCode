// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int i,j;
        Set<Character> set = new HashSet<>();
        for (i = 0, j = 0; j < s.length();) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, j - i );
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
            if (i+maxLen >= s.length()) {
                break;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aabbdccc";
        long  startTime = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring(s));
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime) + "ms");
    }
}
