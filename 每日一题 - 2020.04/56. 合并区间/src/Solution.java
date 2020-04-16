import java.util.Arrays;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        int[][] mergedArray = new int[intervals.length][];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int leftEnd = intervals[i][0], rightEnd = intervals[i][1];
            if (index == -1 || mergedArray[index][1] < leftEnd) {
                mergedArray[++index] = intervals[i];
            } else if (mergedArray[index][1] >= leftEnd) {
                mergedArray[index][1] = Math.max(rightEnd, mergedArray[index][1]);
            }
        }
        return Arrays.copyOf(mergedArray, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}})));
    }
}
