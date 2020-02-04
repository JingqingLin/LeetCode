import java.util.Arrays;

public class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p = 0, q = 0;
        while (p < g.length && q < s.length) {
            if (g[p] <= s[q]) {
                p++;
                q++;
            }
            else {
                q++;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
