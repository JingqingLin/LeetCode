import java.util.Arrays;

public class Solution {
    public static int findLucky(int[] arr) {
        int size = arr.length;
        int[] cnt = new int[size + 1];
        for (int i : arr) {
            if (i > size || i < 0) {
                continue;
            }
            cnt[i]++;
        }
        for (int i = size; i > 0; i--) {
            if (i == cnt[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
    }
}
