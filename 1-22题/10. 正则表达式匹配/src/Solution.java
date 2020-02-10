// 官方题解：回溯

public class Solution {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // p 的匹配模式有两种 1. 单字符 ./a/b/c/... 2. 双字符 a*/b*/c*.../.*
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // p 下个字符为 * ，因此 p 中 a*/b*/c*.../.* 为当前匹配
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // isMatch(s, p.substring(2))： s 当前字符与当前 p 不匹配或匹配完毕，尝试把 p 向后推 2 位
            // isMatch(s.substring(1), p))：* 能匹配多个字符，把 s 向后推一位继续和 * 匹配
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        }
        // 单个字符 a/b/c/.../. 为当前匹配
        else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aabb", ".*b"));
    }
}
