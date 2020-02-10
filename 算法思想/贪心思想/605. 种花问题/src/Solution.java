public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            if (n == 0) {
                return true;
            } else if (n == 1) {
                return flowerbed[0] == 0;
            }
            return false;
        }
        // 官方题解把端点情况放在一起判断
        int cnt = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            cnt++;
        }
        if (cnt >= n) {
            return true;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                cnt++;
                i++;
            }
            if (cnt >= n) {
                return true;
            }
        }
        if (flowerbed[len - 2] == 0 && flowerbed[len - 1] == 0) {
            cnt++;
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1}, 0));
    }
}
