public class Solution {
    public static boolean judgeSquareSum(int c) {
        int sqrtNum = (int) Math.sqrt(c);
        int l = 0, r = sqrtNum;
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }
}
