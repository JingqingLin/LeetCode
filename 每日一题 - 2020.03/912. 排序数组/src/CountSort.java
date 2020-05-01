import java.util.Arrays;

public class CountSort {
    public static int[] sortArray(int[] nums) {
        countSort(nums);
        return nums;
    }

    private static void countSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 找到最大最小值
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 建立新数组
        int[] count = new int[max - min + 1];
        // 统计每个元素出现频率
        for (int num : nums) {
            count[num - min]++;
        }
        int cur = 0;
        // 根据出现频率把计数数组中的元素放回到旧数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[cur++] = i + min;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92})));
    }
}
