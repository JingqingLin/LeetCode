import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        if (target < 3) {
            return lists.toArray(new int[0][]);
        }
        long sum;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 0);
        for (int i = 1; i <= target / 2 + 1; i++) {
            sum = (long) (1 + i) * i / 2;
            map.put(sum, i);
            if (sum >= target && map.get(sum - target) != null) {
                int l = map.get(sum - target);
                int[] temp = new int[i - l];
                for (int j = l + 1; j <= i; j++) {
                    temp[j - l - 1] = j;
                }
                lists.add(temp);
            }
        }
        return lists.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(94527)));
    }
}
