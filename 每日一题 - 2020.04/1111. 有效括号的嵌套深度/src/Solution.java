import java.util.Arrays;

public class Solution {
    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        int index = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                depth++;
                ans[index++] = depth % 2;
            } else {
                ans[index++] = depth % 2;
                depth--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(()())")));
    }
}
