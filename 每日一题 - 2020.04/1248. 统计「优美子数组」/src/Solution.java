import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int evenNums = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                evenNums++;
            } else {
                list.add(evenNums + 1);
                evenNums = 0;
            }
        }
        list.add(evenNums + 1);
        int count = 0;
        for (int i = 0; i < list.size() - k; i++) {
            count += (list.get(i) * list.get(i + k));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 1, 2, 1, 2, 2, 2}, 2));
    }
}
