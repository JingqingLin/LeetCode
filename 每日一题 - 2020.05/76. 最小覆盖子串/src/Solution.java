import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> needs;
    private static Map<Character, Integer> window;

    public static String minWindow(String s, String t) {
        // 用来统计 t 中每个字符出现次数
        needs = new HashMap<>();
        window = new HashMap<>();
        char[] str = s.toCharArray();
        char[] target = t.toCharArray();

        for (char c : target) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int ansLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int strLen = str.length;

        while (r < strLen) {
            r++;
            if (r < strLen && needs.containsKey(str[r])) {
                window.put(str[r], window.getOrDefault(str[r], 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < ansLen) {
                    ansLen = r - l + 1;
                    ansL = l;
                    ansR = l + ansLen;
                }
                if (needs.containsKey(str[l])) {
                    window.put(str[l], window.getOrDefault(str[l], 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private static boolean check() {
        for (Map.Entry<Character, Integer> entry : needs.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (window.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
