import java.util.Arrays;

public class Solution {
    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int curSum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if ((target - curSum) / (len - i) < arr[i]) {
                // 四舍五入，但是 0.5 这个值是舍
                return (int) ((target - curSum) * 1.0 / (len - i) + 0.4999999999);
            }
            curSum += arr[i];
        }

        return arr[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{2, 3, 5}, 10));
    }
}