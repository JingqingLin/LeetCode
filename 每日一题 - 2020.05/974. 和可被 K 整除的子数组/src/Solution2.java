import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        int tempSum = 0, cnt = 0;
        for (int i : A) {
            tempSum += i;
            // 注意取模和取余的区别
            int mod = Math.floorMod(tempSum, K);
            // 找出之前前缀和中，与本次前缀和取模结果相等的个数
            // 如果两个前缀和和取模结果相等，那说明他们之间的元素能被 K 整除
            int same = sum.getOrDefault(mod, 0);
            cnt += same;
            sum.put(mod, same + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(Math.floorMod(-8, 5));
    }
}
