import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlideWindow {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int l = 1, r = 1, sum;
        while (r <= target / 2 + 1) {
            sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) {
                r++;
            } else if (sum > target) {
                l++;
            } else {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                l += 2;
                lists.add(temp);
            }
        }
        return lists.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(94527)));
    }
}
