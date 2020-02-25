import java.util.Arrays;
import java.util.Comparator;


public class Greedy {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int rightEnd = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (rightEnd < pair[0]) {
                rightEnd = pair[1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
