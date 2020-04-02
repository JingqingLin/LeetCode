import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        // 1 << nums.length 为 2^num.length
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 判断一个数的第 j 位是否为 1
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            subsetList.add(sub);
        }
        return subsetList;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{2, 3}));
    }
}
