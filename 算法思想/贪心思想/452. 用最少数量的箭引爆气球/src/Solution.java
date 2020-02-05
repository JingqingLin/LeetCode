import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int cnt = 1;
        int rightEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightEnd) {
                rightEnd = points[i][1] < rightEnd ? points[i][1] : rightEnd;
                continue;
            } else {
                cnt++;
                rightEnd = points[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(
                new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}));
    }
}
