import java.util.Arrays;

public class Solution {
    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[32];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        // 0 个字符时，状态码为 0
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                // a = 00001
                status ^= (1);
            } else if (ch == 'e') {
                // e = 00010
                status ^= (2);
            } else if (ch == 'i') {
                // i = 00100
                status ^= (4);
            } else if (ch == 'o') {
                // o = 01000
                status ^= (8);
            } else if (ch == 'u') {
                // u = 10000
                status ^= (16);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                // 前 i + 1 个字符运算后的状态码为 status
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("mmm"));
    }
}
