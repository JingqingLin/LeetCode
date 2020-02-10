import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bucket {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int item : nums) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1);
        }
        // 设置若干个桶，每个桶存储出现频率相同的数。
        // 桶的下标 (0 ~ nums.length-1)，表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i + 1 。
        List<Integer>[] tempList = new ArrayList[nums.length];
        for (Integer key : hashMap.keySet()) {
            int value = hashMap.get(key);
            if (tempList[value - 1] == null) {
                tempList[value - 1] = new ArrayList<>();
            }
            tempList[value - 1].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (tempList[i] != null && k > 0) {
                for (Integer num : tempList[i]) {
                    list.add(num);
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
